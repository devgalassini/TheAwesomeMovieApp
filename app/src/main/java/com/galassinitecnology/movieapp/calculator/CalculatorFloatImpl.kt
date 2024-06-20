package com.galassinitecnology.movieapp.calculator

class CalculatorFloatImpl : CalculatorInterface<Float> {
    override fun sum(number1: Float, number2: Float): Float {
        return number1 + number2
    }

    override fun multiply(number1: Float, number2: Float): Float {
        return number1 * number2
    }

    override fun subtract(number1: Float, number2: Float): Float {
        return number1 - number2
    }

    override fun divide(number1: Float, number2: Float): Float {
        when (number2) {
            0f -> {
                throw IllegalArgumentException("Cannot divide by zero")
            }
            else -> return number1 / number2
        }
    }
}