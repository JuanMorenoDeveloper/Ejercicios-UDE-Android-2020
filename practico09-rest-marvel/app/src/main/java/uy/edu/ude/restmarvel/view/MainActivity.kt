package uy.edu.ude.restmarvel.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.common.base.Charsets
import com.google.common.hash.Hashing
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import uy.edu.ude.restmarvel.R
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnOk.setOnClickListener {
            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                    val apiKey = "108f278315cda02a5803401df0c0ee4a"
                    val privateKey = "a921cbf3c04d7b44b934279888a15ff34a9c8c5e"
                    val timestamp = System.currentTimeMillis()
                    val hash = Hashing.md5().hashString(
                        timestamp.toString() + privateKey + apiKey,
                        Charsets.UTF_8
                    ).toString()
                    val url =
                        URL(
                            """
                https://gateway.marvel.com/v1/public/characters/1009610?ts=$timestamp&apikey=$apiKey&hash=$hash
                """
                        )
                    val client = OkHttpClient()
                    val request: Request
                    val response: okhttp3.Response

                    client.run {
                        request = Request.Builder()
                            .url(url)
                            .build()
                        response = client.newCall(request).execute()
                    }
                    //El response.body solo se puede llamar una vez, luego cierra el buffer
                    val json = JSONObject(response.body!!.string())
                    Log.i("MainActivity", json.toString())
                }
            }
        }
    }
}
