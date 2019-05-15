package com.example.projetojododamemoria

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper (context: Context):
    SQLiteOpenHelper(context, "banco", null, 1){

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table pessoa(id integer primary key autoincrement, nome text, disciplinas text, img text)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}