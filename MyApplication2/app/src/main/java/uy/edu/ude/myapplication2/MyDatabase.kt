package uy.edu.ude.myapplication2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabase(
    val context: Context,
    val name: String?,
    val cursor: SQLiteDatabase.CursorFactory?,
    val version: Int
) : SQLiteOpenHelper(context, name, cursor, version) {

    val sql = "create table usuario (id INTEGER, nombre TEXT)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}