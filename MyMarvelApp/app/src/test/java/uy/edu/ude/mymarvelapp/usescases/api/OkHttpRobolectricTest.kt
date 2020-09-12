package uy.edu.ude.mymarvelapp.usescases.api

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class OkHttpRobolectricTest {

    @Test
    fun givenCharacterId_whenGetCharacterById_getValidCharacter() {
        GlobalScope.launch {
            val api: MarvelApi =
                OkHttpMarvelApi(
                    urlServer = "https://gateway.marvel.com/v1/public/characters",
                    apiKey = "108f278315cda02a5803401df0c0ee4a",
                    privateKey = "a921cbf3c04d7b44b934279888a15ff34a9c8c5e"
                )

            val character = api.getCharacterById(1009610)

            assertThat(character.name).isEqualTo("Spider-Man")
        }
    }


}