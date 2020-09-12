package uy.edu.ude.mymarvelapp.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import uy.edu.ude.mymarvelapp.R
import uy.edu.ude.mymarvelapp.entities.Character
import uy.edu.ude.mymarvelapp.presenter.MainPresenter
import uy.edu.ude.mymarvelapp.presenter.Presenter
import uy.edu.ude.mymarvelapp.usescases.api.MarvelApi
import uy.edu.ude.mymarvelapp.usescases.api.OkHttpMarvelApi

class MainActivity : AppCompatActivity(), MainView {
    lateinit var presenter: Presenter
    lateinit var api: MarvelApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        api = OkHttpMarvelApi(
            "https://gateway.marvel.com/v1/public/characters",
            "108f278315cda02a5803401df0c0ee4a",
            "a921cbf3c04d7b44b934279888a15ff34a9c8c5e"
        )
        presenter = MainPresenter(this, api)
        initComponents()
    }

    private fun initComponents() {
        btnSend.setOnClickListener {
            sendRequest(1009368)
        }
    }

    override fun sendRequest(id: Int) {
        lifecycleScope.launch {
            presenter.sendRequest(id)
        }
    }

    override fun showCharacter(character: Character) {
        tvId.text = character.id.toString()
        tvName.text = character.name
        tvDescription.text = character.description.substring(0, 25) + "..."
        tvNrComics.text = character.nrComics.toString()
        Log.i("MainActivity", character.thumbnailUrl)
        Picasso.get().load(character.thumbnailUrl).into(ivCharacter)
        //Carga imagenes
    }
}