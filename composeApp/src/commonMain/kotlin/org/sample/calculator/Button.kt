package org.sample.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Gray Button
@Composable
fun digitButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (String) -> Unit,
) {
    flatButton(
        modifier = modifier,
        text = text,
        backgroundColor = Color.Gray,
        onClick = onClick
    )
}

// Yellow Button
@Composable
fun operatorButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (String) -> Unit,
) {
    flatButton(
        modifier = modifier,
        text = text,
        backgroundColor = Color.Yellow,
        onClick = onClick
    )
}

// Button Component
@Composable
fun flatButton(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color,
    contentColor: Color = Color.White,
    onClick: (String) -> Unit,
) {
    Button(modifier = modifier
        .heightIn(min = 80.dp)
        .padding(10.dp)
        .background(color = backgroundColor),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        onClick = { onClick(text) }) {
            Text(
                text = text,
                style = TextStyle(fontSize = 30.sp)
            )
    }
}