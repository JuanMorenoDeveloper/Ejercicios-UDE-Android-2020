package uy.edu.ude.restclient.main.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import uy.edu.ude.restclient.R
import uy.edu.ude.restclient.entities.Response
import uy.edu.ude.restclient.main.presenter.MainPresenter
import uy.edu.ude.restclient.main.presenter.Presenter
import uy.edu.ude.restclient.usecases.DefaultRetrofitQuoteApi

class MainActivity : AppCompatActivity(), MainView {

    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(
            this,
            //OkHttpQuoteApi("https://gturnquist-quoters.cfapps.io/api/random")
            //HttpUrlConnectionQuoteApi("https://gturnquist-quoters.cfapps.io/api/random")
            DefaultRetrofitQuoteApi("https://gturnquist-quoters.cfapps.io/")
        )
        initComponents()
    }

    private fun initComponents() {
        btnSend.setOnClickListener {
            pbProgress.visibility = View.VISIBLE
            doRequest()
        }
    }

    override fun doRequest() {
        lifecycleScope.launch {
            presenter.sendGet()
        }
    }

    override fun showResponse(response: Response) {
        pbProgress.visibility = View.GONE
        tvId.text = response.id.toString()
        tvType.text = response.type
        tvQuote.text = response.quote
    }
}