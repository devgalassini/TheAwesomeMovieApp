package com.galassinitecnology.movieapp.calculator



class CalculatorIntImpl : CalculatorInterface<Int> {
    override fun sum(number1: Int, number2: Int): Int {
        return number1 + number2
    }

    override fun multiply(number1: Int, number2: Int): Int {
        return number1 * number2
    }

    override fun subtract(number1: Int, number2: Int): Int {
        return number1 - number2
    }

    override fun divide(number1: Int, number2: Int): Int {
        when (number2) {
            0 -> {
                throw IllegalArgumentException("Cannot divide by zero")
            }
            else -> return number1 / number2
        }
    }


}