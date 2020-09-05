package uy.edu.ude.restclient.usecases

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import uy.edu.ude.restclient.entities.Response


@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class HttpUrlConnectionRobolectricTest {

    @Test
    fun givenJsonStr_whenStrToResponse_getResponse() {
        //arrange
        val api = HttpUrlConnectionQuoteApi("")
        val str = """
            {
              "type": "success",
              "value": {
                "id": 2,
                "quote": "With Boot you deploy everywhere you can find a JVM basically."
              }
            }
        """
        val responseExpected =
            Response(2, "success", "With Boot you deploy everywhere you can find a JVM basically.")
        //act

        val response = Converter().strToResponse(str)

        //assert
        assertThat(response).isEqualTo(responseExpected)
    }
}