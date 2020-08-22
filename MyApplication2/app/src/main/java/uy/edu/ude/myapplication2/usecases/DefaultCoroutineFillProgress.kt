package uy.edu.ude.myapplication2.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import uy.edu.ude.myapplication2.main.presenter.MainPresenter

class DefaultCoroutineFillProgress : CoroutineFillProgress {

    override suspend fun doInBackground(presenter: MainPresenter) {
        withContext(Dispatchers.Default) {
            for (i in 0..100 step 10) {
                if (isActive) {
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