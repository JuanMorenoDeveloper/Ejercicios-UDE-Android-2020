package uy.edu.ude.usecases.consulta

import uy.edu.ude.entity.Lectura

class DefaultLecturaRepository(val lecturas: ArrayList<Lectura>) : LecturaRepository {

    override fun findById(id: Int): Lectura? {
//        for (lectura in lecturas) {
//            if (lectura.id == id) {
//                return lectura
//            }
//        }
//        return null
        return lecturas.find { it.id == id }
    }
}