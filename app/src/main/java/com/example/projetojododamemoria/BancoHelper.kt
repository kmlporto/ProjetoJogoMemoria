package com.example.projetojododamemoria

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper (context: Context):
    SQLiteOpenHelper(context, "teste", null, 1){

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table professor(id integer primary key autoincrement, nome text, disciplinas text, img integer)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}