package uy.edu.ude.restclient.usecases

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class HttpUrlConnectionIntegrationTest {

    @Test
    fun givenBadUrl_whenGetQuoteRandom_getTypeError() {
        //arrange
        val api: QuoteApi =
            HttpUrlConnectionQuoteApi("https://gturnquist-quoters.cfapps.io/api/random21321312312")
        val typeExpected = "error"
        //act

        val response = api.getQuoteRandom()

        //assert
        assertThat(response.type).isEqualTo(typeExpected)
    }
    @Test
    fun whenGetQuoteRandom_getTypeSuccess() {
        //arrange
        val api: QuoteApi =
            HttpUrlConnectionQuoteApi("https://gturnquist-quoters.cfapps.io/api/random")
        val typeExpected = "success"
        //act

        val response = api.getQuoteRandom()

        //assert
        assertThat(response.type).isEqualTo(typeExpected)
    }
}