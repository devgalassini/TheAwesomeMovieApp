package com.galassinitecnology.movieapp

import com.galassinitecnology.movieapp.calculator.CalculatorFloatImpl
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class CalculatorFloatImplTest {

    private lateinit var calculator: CalculatorFloatImpl

    @Before
    fun setup() {
        calculator = CalculatorFloatImpl()
    }

    @Test
    fun sum_when_receivingTwoNumbers_shouldReturnTheSum() {
        val result = calculator.sum(1f, 2f)
        Truth.assertThat(result).isEqualTo(3f)
    }

    @Test
    fun subtract_when_receivingTwoNumbers_shouldReturnTheSubtraction() {
        val result = calculator.subtract(5f, 3f)
        Truth.assertThat(result).isEqualTo(2f)
    }

    @Test
    fun multiply_when_receivingTwoNumbers_shouldReturnTheMultiplication() {
        val result = calculator.multiply(2f, 4f)
        Truth.assertThat(result).isEqualTo(8f)
    }

    @Test
    fun divide_when_receivingTwoNumbers_shouldReturnTheDivision() {
        val result = calculator.divide(10f, 2f)
        Truth.assertThat(result).isEqualTo(5f)
    }

    @Test(expected = IllegalArgumentException::class)
    fun divide_when_dividingByZero_shouldThrowException() {
        calculator.divide(10f, 0f)
    }

}