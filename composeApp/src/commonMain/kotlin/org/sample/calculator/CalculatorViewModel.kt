package org.sample.calculator

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculatorViewModel {

    private val _state = MutableStateFlow(CalculatorState())
    val state = _state.asStateFlow()

    // ボタンが呼び出されたときの処理
    fun onOperatorClicked(buttonValue: String) {
        when(buttonValue) {
            "AC" ->  _state.update { CalculatorState() }
            "+/-" -> { unaryMinus() }
            "+", "-", "/", "%", "*" -> {
                _state.update {
                    it.copy(
                        firstOperand = it.currentOperand,
                        operator = buttonValue,
                        currentOperand = "0"
                    )
                }
            }
            "." -> {
                addDecimal()
            }
            "=" -> {
                calculateResult()
            }
            else -> {
                _state.update {
                    it.copy(currentOperand = "${it.currentOperand.trimStart('0')}$buttonValue")
                }
            }
        }
    }

    private fun calculateResult() {
        val first = _state.value.firstOperand.toDoubleOrNull()
        val second = _state.value.currentOperand.toDoubleOrNull()
        if (first == null || second == null) return
        _state.update {
            when(it.operator) {
                "/" -> CalculatorState(currentOperand = if (second == 0.0) "0" else (first/second).toString())
                "*" -> CalculatorState(currentOperand = (first*second).toString())
                "+" -> CalculatorState(currentOperand = (first+second).toString())
                "-" -> CalculatorState(currentOperand = (first-second).toString())
                "%" -> CalculatorState(currentOperand = (first%second).toString())
                else -> it
            }
        }
    }

    private fun addDecimal() {
        _state.update {
            it.copy(
                currentOperand = it.currentOperand.trimEnd('.')
            )
        }
    }

    private fun unaryMinus() {
        val value = _state.value.currentOperand.toDoubleOrNull() ?: 0.0
        if(value != 0.0) {
            _state.update {
                it.copy(currentOperand = value.unaryMinus().toString())
        }}
    }
}