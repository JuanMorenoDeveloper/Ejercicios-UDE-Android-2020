package uy.edu.ude.myapplication2.main.presenter

import uy.edu.ude.myapplication2.main.view.MainView
import uy.edu.ude.myapplication2.usecases.FillProgress
import java.util.concurrent.atomic.AtomicBoolean

class DefaultMainPresenter(private val view: MainView, private val fillProgress: FillProgress) :
    MainPresenter {
    private val control = AtomicBoolean(false)

    override fun setControl(estado: Boolean) {
        control.set(estado)
    }

    override fun getControl(): Boolean {
        return control.get()
    }

    override fun actualizarProgreso(progreso: Int) {
        view.actualizarProgreso(progreso)
    }

    override fun start() {
        fillProgress.doInBackground(this)
    }

}