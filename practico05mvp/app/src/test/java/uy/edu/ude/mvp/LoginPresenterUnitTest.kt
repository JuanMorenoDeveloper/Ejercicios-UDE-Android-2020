package uy.edu.ude.mvp

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import uy.edu.ude.mvp.login.presenter.DefaultLoginPresenter
import uy.edu.ude.mvp.login.presenter.LoginPresenter
import uy.edu.ude.mvp.login.view.LoginActivity
import uy.edu.ude.mvp.model.entity.Usuario
import uy.edu.ude.mvp.model.usecases.LoginVerifier

class LoginPresenterUnitTest {
    @Test
    fun givenInvalidCredentials_whenCallLoginVerifier_thenGetEmptyUser() {
        //arrange
        val loginPresenter: LoginPresenter =
            DefaultLoginPresenter(LoginActivityFake(), LoginVerifier())
        //act
        val usuario = loginPresenter.callLoginVerifier(Usuario("Test", "Test"))
        //assert
        assertThat(usuario).isEqualTo(Unit)
    }

    @Test
    fun givenInvalidCredentialsWithMockActivity_whenCallLoginVerifier_thenGetEmptyUser() {
        //arrange
        val activity = mockk<LoginActivity>()
        every { activity.showMessage(any()) } returns Unit
        val loginPresenter: LoginPresenter =
            DefaultLoginPresenter(activity, LoginVerifier())

        //act
        val usuario = loginPresenter.callLoginVerifier(Usuario("Test", "Test"))
        //assert
        assertThat(usuario).isEqualTo(Unit)
    }
}