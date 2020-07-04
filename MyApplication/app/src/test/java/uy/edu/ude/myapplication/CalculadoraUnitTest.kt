package uy.edu.ude.myapplication

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CalculadoraUnitTest {

    @Test
    fun whenSumar_thenGetResult() {
        //Arrange - Preparación
        val calculadora = CalculadoraActivity(n1 = 2, n2 = 2)
        val resultExpected = 4

        //Act - Ejecución
        val result = calculadora.sumar()

        //Assert -> Verificación
        assertThat(result).isEqualTo(resultExpected)
    }

    @Test
    fun givenValidN2_whenDivide_thenGetResult() {
        val calculadora = CalculadoraActivity(1, 2)
        val resultExpected = "0.5"

        val result = calculadora.tryDivide()

        assertThat(result).isEqualTo(resultExpected)
    }

    @Test
    fun givenN2eqZero_whenDivide_thenGetInfinity() {
        val calculadora = CalculadoraActivity(1, 0)

        val result = calculadora.dividir()

        assertThat(result).isEqualTo(Double.POSITIVE_INFINITY)
    }

    @Test
    fun givenN2eqZero_whenTryDivide_thenGetResult() {
        val calculadora = CalculadoraActivity(1, 0)
        val resultExpected = "El número 2 no puede ser 0"

        val result = calculadora.tryDivide()

        assertThat(result).isEqualTo(resultExpected)
    }


}