package org.sample.calculator

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun App() {
    MaterialTheme {
        Column(Modifier.fillMaxSize()) {
            Text(
                text = "0",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.End)
                    .padding(10.dp)
                    .background(color = Color.DarkGray),
                style = TextStyle(fontSize = 45.sp)
            )
        }
    }
}