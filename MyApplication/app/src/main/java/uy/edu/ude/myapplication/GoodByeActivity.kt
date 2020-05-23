package uy.edu.ude.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uy.edu.ude.myapplication.databinding.ActivityGoodByeBinding

class GoodByeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGoodByeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvBye.text = "Good bye"
    }
}
