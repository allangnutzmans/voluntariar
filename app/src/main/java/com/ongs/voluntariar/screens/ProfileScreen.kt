package com.ongs.voluntariar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.ongs.voluntariar.ui.theme.Purple80

@Composable
fun ProfileScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var message by remember { mutableStateOf<String?>(null) }
    var isUpdating by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val user = FirebaseAuth.getInstance().currentUser
    val borderColor = Color(0xFF4A0247)

    //Carrega o email
    LaunchedEffect(user) {
        user?.let {
            name = it.displayName ?: ""
            email = it.email ?: ""
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {}

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Usuário", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        //Mostra o email, mas não permite alteração
        OutlinedTextField(
            value = email,
            onValueChange = { },
            label = { Text("Email") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = currentPassword,
            onValueChange = { currentPassword = it },
            label = { Text("Senha Atual") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            label = { Text("Nova Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (message != null) {
            Text(text = message!!, color = if (message!!.contains("sucesso")) Color.Green else Color.Red)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Button(
            onClick = {
                isUpdating = true
                message = null

                val user = FirebaseAuth.getInstance().currentUser

                if (user != null && currentPassword.isNotEmpty()) {
                    val credential = EmailAuthProvider.getCredential(user.email!!, currentPassword)

                    user.reauthenticate(credential)
                        .addOnCompleteListener { reauthTask ->
                            if (reauthTask.isSuccessful) {
                                // Atualizar nome
                                val profileUpdates = UserProfileChangeRequest.Builder()
                                    .setDisplayName(name)
                                    .build()

                                user.updateProfile(profileUpdates)
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            message = "Nome atualizado com sucesso!"
                                        } else {
                                            message = "Erro ao atualizar nome."
                                        }
                                    }

                                //  Atualizar senha
                                if (newPassword.isNotEmpty()) {
                                    user.updatePassword(newPassword)
                                        .addOnCompleteListener { task ->
                                            if (task.isSuccessful) {
                                                message = "Senha atualizada com sucesso!"
                                            } else {
                                                message = "Erro ao atualizar senha."
                                            }
                                        }
                                }
                            } else {
                                message = "Reautenticação falhou. Tente novamente."
                            }
                            isUpdating = false
                        }
                } else {
                    message = "Informe sua senha atual para atualizar o perfil."
                    isUpdating = false
                }
            },
            enabled = !isUpdating,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A0247)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Alterar informações")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Logout
        Button(
            onClick = {
                FirebaseAuth.getInstance().signOut()
                navController.navigate("signIn") {
                    popUpTo("signIn") { inclusive = true } // 🔥 Limpa navegação e garante que o usuário vá para login
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF45002E)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Fazer logout")
    }}}