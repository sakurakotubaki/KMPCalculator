package org.sample.calculator

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun App() {
    val buttons = remember {
        listOf(
            listOf("AC", "+/-", "%", "/"),
            listOf("7", "8", "9", "x"),
            listOf("4", "5", "6", "-"),
            listOf("1", "2", "3", "+"),
            listOf("0", ".", "="),
        )
    }
    val operators = remember { listOf("/", "*", "+", "-", "=") }
    val extraOperators = remember { listOf("AC", "+/-", "%") }
    MaterialTheme(colors = themeColors()) {
        Column(Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "0",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.End)
                    .padding(10.dp)
                    .background(color = Color.DarkGray),
                textAlign = TextAlign.End,
                color = Color.White,
                style = TextStyle(fontSize = 45.sp)
            )
            // buttonをforEachでloopする。
            buttons.forEach { rowButtons ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    rowButtons.forEachIndexed { index, item ->
                        when {
                            extraOperators.contains(item) -> {
                                extraButton(
                                    modifier = Modifier.weight(1f),
                                    text = item,
                                    onClick = {  }
                                )
                            }
                            operators.contains(item) -> {
                                operatorButton(
                                    modifier = Modifier.weight(1f),
                                    text = item,
                                    onClick = {  }
                                )
                            }
                            else -> {
                                digitButton(
                                    // To make 0 button
                                    modifier = Modifier.weight(
                                        if (rowButtons.size < 4 && index == 0) 2f else 1f
                                    ),
                                    text = item,
                                    onClick = {  }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun themeColors(): Colors {
    return Colors(
        primary = Color.Gray,
        primaryVariant = Color.DarkGray,
        secondary = Color(242, 163, 60, 255),
        secondaryVariant = Color.Yellow,
        background = Color.Black,
        surface = MaterialTheme.colors.surface,
        error = MaterialTheme.colors.error,
        onPrimary = MaterialTheme.colors.onPrimary,
        onSecondary = MaterialTheme.colors.onSecondary,
        onBackground = MaterialTheme.colors.onBackground,
        onSurface = MaterialTheme.colors.onSurface,
        onError = MaterialTheme.colors.onError,
        isLight = MaterialTheme.colors.isLight
    )
}