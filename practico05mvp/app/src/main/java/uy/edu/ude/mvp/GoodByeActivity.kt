package uy.edu.ude.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uy.edu.ude.mvp.databinding.ActivityGoodByeBinding

class GoodByeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGoodByeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvBye.text = "Good bye"
    }
}
