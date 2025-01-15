package org.sample.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator() {
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
    val viewModel = remember { CalculatorViewModel() }
    val state = viewModel.state.collectAsState()
    MaterialTheme(colors = themeColors()) {
        Column(Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = state.value.currentOperand,
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
                                    onClick = viewModel::onOperatorClicked
                                )
                            }
                            operators.contains(item) -> {
                                operatorButton(
                                    modifier = Modifier.weight(1f),
                                    text = item,
                                    onClick = viewModel::onOperatorClicked
                                )
                            }
                            else -> {
                                digitButton(
                                    // To make 0 button
                                    modifier = Modifier.weight(
                                        if (rowButtons.size < 4 && index == 0) 2f else 1f
                                    ),
                                    text = item,
                                    onClick = viewModel::onOperatorClicked
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}