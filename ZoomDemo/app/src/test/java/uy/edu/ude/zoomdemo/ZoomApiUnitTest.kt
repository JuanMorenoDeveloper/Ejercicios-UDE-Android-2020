package uy.edu.ude.zoomdemo

import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.Request
import org.assertj.core.api.SoftAssertions.assertSoftly
import org.junit.Test
import java.io.IOException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ZoomApiUnitTest {
    @Test
    @Throws(IOException::class)
    fun givenAuthUser_whenGetUsuario_thenGetResponseOk() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://zoomx.freeddns.org:8443/usuario")
            .header("Authorization", Credentials.basic("adm", "adm"))
            .build()
        val rolExpected = "ROLE_ADMIN"
        val response = client.newCall(request).execute()
        val body = response.body!!.string()
        //println(body)
        assertSoftly {
            it.assertThat(response.code).isEqualTo(200)
            it.assertThat(body).contains(rolExpected)
        }
        response.close()
    }

    @Test
    @Throws(IOException::class)
    fun givenUnauthUser_whenGetUsuario_thenGetResponseOk() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://zoomx.freeddns.org:8443/usuario")
            .header("Authorization", Credentials.basic("adm1", "adm1"))
            .build()
        val response = client.newCall(request).execute()
        val body = response.body!!.string()
        assertSoftly {
            it.assertThat(response.code).isEqualTo(401)
            it.assertThat(body).contains("Unauthorized")
        }
        response.close()
    }
}