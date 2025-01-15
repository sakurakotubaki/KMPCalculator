package org.sample.calculator

// 状態クラス
data class CalculatorState(
    val firstOperand : String = "0",
    val currentOperand : String = "0",
    val operator : String = ""
)