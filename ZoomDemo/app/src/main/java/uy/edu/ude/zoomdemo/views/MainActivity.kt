package uy.edu.ude.zoomdemo.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import uy.edu.ude.zoomdemo.R
import uy.edu.ude.zoomdemo.entities.Credenciales
import uy.edu.ude.zoomdemo.usescases.ClientZoomApi
import uy.edu.ude.zoomdemo.usescases.ZoomApi

class MainActivity : AppCompatActivity() {

    private lateinit var api: ZoomApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        api = ClientZoomApi(Credenciales("adm", "adm"), "https://zoomx.freeddns.org:8443/usuario")
        init()
    }

    private fun init() {
        btnSend.setOnClickListener {
            lifecycleScope.launch {
                tvResult.text = api.send().toString()
            }
        }
    }
}