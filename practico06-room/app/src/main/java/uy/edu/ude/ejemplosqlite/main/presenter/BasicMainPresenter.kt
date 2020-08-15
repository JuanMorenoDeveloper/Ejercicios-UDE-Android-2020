package uy.edu.ude.ejemplosqlite.main.presenter

import kotlinx.coroutines.runBlocking
import uy.edu.ude.ejemplosqlite.entity.Command
import uy.edu.ude.ejemplosqlite.entity.Command.*
import uy.edu.ude.ejemplosqlite.entity.Usuario
import uy.edu.ude.ejemplosqlite.main.interactor.DbInteractor
import uy.edu.ude.ejemplosqlite.main.view.MainView

class BasicMainPresenter(private val view: MainView, private val interactor: DbInteractor) :
    MainPresenter {

    override fun sendCommand(usuario: Usuario, command: Command) {
        val result = runBlocking {
            when (command) {
                INSERT -> interactor.save(usuario)
                SEARCH -> interactor.findById(usuario.id)
                SEARCH_ALL -> interactor.findAll()
                UPDATE -> interactor.update(usuario)
                DELETE -> interactor.delete(usuario)
            }
        }
        showResults(result)
    }

    override fun showResults(results: String) {
        view.showResults(results)
    }

}