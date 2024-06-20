package com.galassinitecnology.movieapp

import com.galassinitecnology.movieapp.calculator.Calculator
import com.galassinitecnology.movieapp.calculator.CalculatorFloatImpl
import com.galassinitecnology.movieapp.calculator.CalculatorIntImpl
import com.galassinitecnology.movieapp.calculator.Operations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorTest {

    @get:Rule
    val mockkRule = MockKRule(this)

    lateinit var calculator: Calculator

    @MockK
    lateinit var calculatorIntImpl: CalculatorIntImpl

    @MockK
    lateinit var calculatorFloatImpl: CalculatorFloatImpl
    @Before
    fun setup() {
        every {
            calculatorIntImpl.sum(any(), any())
        } returns 3

        every {
            calculatorIntImpl.subtract(any(), any())
        } returns 3

        every {
            calculatorIntImpl.divide(any(), any())
        } returns 4

        every {
            calculatorIntImpl.multiply(any(), any())
        } returns 3

        every {
            calculatorFloatImpl.sum(any(), any())
        } returns 3f

        every {
            calculatorFloatImpl.subtract(any(), any())
        } returns 3f

        every {
            calculatorFloatImpl.divide(any(), any())
        } returns 4f

        every {
            calculatorFloatImpl.multiply(any(), any())
        } returns 3f

        calculator = Calculator(
            calculatorIntImpl,
            calculatorFloatImpl
        )
    }

    @Test
    fun operation_whenOperationSum_AndTwoNumbersInt_thenShouldCallInt(){
        calculator.calculate(Operations.SUM, 1, 2)
            verify(exactly = 1) {
                calculatorIntImpl.sum(1, 2)
            }
    }

    @Test
    fun operation_whenOperationSub_AndTwoNumbersInt_thenShouldCallInt(){
        calculator.calculate(Operations.SUBTRACT, 4, 1)
        verify(exactly = 1) {
            calculatorIntImpl.subtract(4, 1)
        }
    }

    @Test
    fun operation_whenOperationDivide_AndTwoNumbersInt_thenShouldCallInt(){
        calculator.calculate(Operations.DIVIDE, 4, 1)
        verify(exactly = 1) {
            calculatorIntImpl.divide(4, 1)
        }
    }

    @Test
    fun operation_whenOperationMultiply_AndTwoNumbersInt_thenShouldCallInt(){
        calculator.calculate(Operations.MULTIPLY, 1, 3)
        verify(exactly = 1) {
            calculatorIntImpl.multiply(1, 3)
        }
    }

    @Test
    fun operation_whenOperationSum_AndTwoNumbersFloat_thenShouldCallFloat(){
        calculator.calculate(Operations.SUM, 1f, 2f)
        verify(exactly = 1) {
            calculatorFloatImpl.sum(1f, 2f)
        }
    }

    @Test
    fun operation_whenOperationSub_AndTwoNumbersFloat_thenShouldCallFloat(){
        calculator.calculate(Operations.SUBTRACT, 4f, 1f)
        verify(exactly = 1) {
            calculatorFloatImpl.subtract(4f, 1f)
        }
    }

    @Test
    fun operation_whenOperationDivide_AndTwoNumbersFloat_thenShouldCallFloat(){
        calculator.calculate(Operations.DIVIDE, 4f, 1f)
        verify(exactly = 1) {
            calculatorFloatImpl.divide(4f, 1f)
        }
    }

    @Test
    fun operation_whenOperationMultiply_AndTwoNumbersFloat_thenShouldCallFloat(){
        calculator.calculate(Operations.MULTIPLY, 1f, 3f)
        verify(exactly = 1) {
            calculatorFloatImpl.multiply(1f, 3f)
        }
    }

    @Test(expected = IllegalArgumentException::class)
    fun operation_whenOperationSum_AndTwoNumberDouble_thenShouldThrowException(){

        calculator.calculate(Operations.SUM, 1.0, 2.0)
    }
}