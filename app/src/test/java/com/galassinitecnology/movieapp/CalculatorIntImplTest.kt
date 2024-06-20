package com.galassinitecnology.movieapp

import com.galassinitecnology.movieapp.calculator.CalculatorIntImpl
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class CalculatorIntImplTest {

    private lateinit var calculator: CalculatorIntImpl

    @Before
    fun setup() {
        calculator = CalculatorIntImpl()
    }

    @Test
    fun sum_when_receivingTwoNumbers_shouldReturnTheSum() {
        val result = calculator.sum(1, 2)
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun subtract_when_receivingTwoNumbers_shouldReturnTheSubtraction() {
        val result = calculator.subtract(5, 3)
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun multiply_when_receivingTwoNumbers_shouldReturnTheMultiplication() {
        val result = calculator.multiply(2, 4)
        assertThat(result).isEqualTo(8)
    }

    @Test
    fun divide_when_receivingTwoNumbers_shouldReturnTheDivision() {
        val result = calculator.divide(10, 2)
        assertThat(result).isEqualTo(5)
    }

    @Test(expected = IllegalArgumentException::class)
    fun divide_when_dividingByZero_shouldThrowException() {
        calculator.divide(10, 0)
    }

}