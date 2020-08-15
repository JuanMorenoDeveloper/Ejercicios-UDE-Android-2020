package uy.edu.ude.myapplication2.usecases

import uy.edu.ude.myapplication2.main.presenter.MainPresenter
import java.util.concurrent.ExecutorService

class DefaultFillProgress(
    private val executor: ExecutorService
) : FillProgress {

    override fun doInBackground(presenter: MainPresenter) {
        executor.execute {
            presenter.setControl(true)
            for (i in 0..100 step 10) {
                if (presenter.getControl()) {
                    try {
                        Thread.sleep(500)
                    } catch (e: InterruptedException) {
                        Thread.currentThread().interrupt()
                    }
                    presenter.actualizarProgreso(i)
                } else {
                    break//return es otra opción
                }
            }
        }
    }
}