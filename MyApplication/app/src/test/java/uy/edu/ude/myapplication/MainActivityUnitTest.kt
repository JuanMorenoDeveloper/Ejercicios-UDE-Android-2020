package uy.edu.ude.myapplication

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MainActivityUnitTest {

    @Test
    fun givenValidUserCredentials_whenIsValid_thenGetTrue() {
        //Arrange
        val main = MainActivity()
        val user = "user"
        val password = "pass"

        //Act
        val result = main.isValid(user, password)

        //Assert
        assertThat(result).isTrue()
    }

    @Test
    fun givenInvalidUserCredentials_whenIsValid_thenGetFalse() {
        //Arrange
        val main = MainActivity()
        val user = "user"
        val password = "pass2"

        //Act
        val result = main.isValid(user, password)

        //Assert
        assertThat(result).isFalse()
    }
}