package com.galassinitecnology.movieapp.calculator

interface CalculatorInterface<N> {

    fun  sum(number1: N, number2: N): N
    fun multiply(number1: N, number2: N): N
    fun subtract(number1: N, number2: N): N
    fun divide(number1: N, number2: N): N


}