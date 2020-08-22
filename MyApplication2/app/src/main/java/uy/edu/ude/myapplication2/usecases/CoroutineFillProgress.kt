package uy.edu.ude.myapplication2.usecases

import uy.edu.ude.myapplication2.main.presenter.MainPresenter

interface CoroutineFillProgress {
    suspend fun doInBackground(presenter: MainPresenter)
}