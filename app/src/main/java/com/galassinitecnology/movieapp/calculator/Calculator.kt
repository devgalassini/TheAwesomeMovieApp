package com.galassinitecnology.movieapp.calculator


enum class Operations {
    SUM, SUBTRACT, MULTIPLY, DIVIDE
}

class Calculator(
    private val calculatorIntImpl: CalculatorIntImpl,
    private val calculatorFloatImpl: CalculatorFloatImpl
) {


    fun calculate(operation: Operations, number1: Number, number2: Number): Number {

        return if(number1 is Int && number2 is Int){
            when(operation){
                Operations.SUM -> calculatorIntImpl.sum(number1, number2.toInt())
                Operations.SUBTRACT -> calculatorIntImpl.subtract(number1, number2.toInt())
                Operations.MULTIPLY -> calculatorIntImpl.multiply(number1, number2.toInt())
                Operations.DIVIDE -> calculatorIntImpl.divide(number1, number2.toInt())
            }
        } else if(number1 is Float && number2 is Float){
            when(operation){
                Operations.SUM -> calculatorFloatImpl.sum(number1, number2)
                Operations.SUBTRACT -> calculatorFloatImpl.subtract(number1, number2)
                Operations.MULTIPLY -> calculatorFloatImpl.multiply(number1, number2)
                Operations.DIVIDE -> calculatorFloatImpl.divide(number1, number2)
            }
        } else {
            throw IllegalArgumentException("Invalid number type")
        }


    }
}