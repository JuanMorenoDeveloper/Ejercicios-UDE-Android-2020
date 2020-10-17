package uy.edu.ude.zoomdemo.usescases

import uy.edu.ude.zoomdemo.entities.Usuario

interface ZoomApi {
    suspend fun send(): Usuario
}