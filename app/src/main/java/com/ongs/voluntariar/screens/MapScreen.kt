package com.ongs.voluntariar.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ongs.voluntariar.components.MapComponent

@Composable
fun MapScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        MapComponent()
    }
}

@Preview
@Composable
private fun MapScreenPreview() {
    MapScreen()
}