package uy.edu.ude.mvp

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import uy.edu.ude.mvp.model.entity.Usuario
import uy.edu.ude.mvp.model.usecases.LoginVerifier

class LoginVerifierUnitTest {

    @Test
    fun givenValidUser_whenIsValid_thenGetTrue() {
        //Arrange
        val verifier = LoginVerifier()
        val usuario= Usuario("user","pass")

        //Act
        val result = verifier.isValid(usuario)

        //Assert
        assertThat(result).isTrue()
    }

    @Test
    fun givenInvalidUser_whenIsValid_thenGetFalse() {
        //Arrange
        val verifier = LoginVerifier()
        val usuario= Usuario("user","pass2")

        //Act
        val result = verifier.isValid(usuario)

        //Assert
        assertThat(result).isFalse()
    }
}