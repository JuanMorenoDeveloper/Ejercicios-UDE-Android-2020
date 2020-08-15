package uy.edu.ude.myapplication2.main.presenter

interface MainPresenter {
    fun setControl(estado: Boolean)
    fun getControl(): Boolean
    fun actualizarProgreso(progreso: Int)
    fun start()
}
