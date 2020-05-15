package uy.edu.ude.usecases.consulta

import uy.edu.ude.entity.Lectura

interface LecturaRepository {
    fun findById(id: Int): Lectura?
}