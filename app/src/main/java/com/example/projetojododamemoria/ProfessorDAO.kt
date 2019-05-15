package com.example.projetojododamemoria

import android.content.ContentValues
import android.content.Context

class ProfessorDAO {
    private  lateinit var banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    fun insert(p: Professor){
        val cv = ContentValues()
        cv.put("nome", p.nome)
        cv.put("disciplinas", p.disciplinas)
        cv.put("img", p.img)
        this.banco.writableDatabase.insert("professor", null, cv)
    }

    fun get(): ArrayList<Professor>{
    val colunas = arrayOf("id", "nome", "disciplinas", "img")
        val lista = ArrayList<Professor>()

        val c = this.banco.readableDatabase.query("professor", colunas, null, null, null, null, "nome")
        c.moveToFirst()

        if(c.count >0){
            do{
                val id = c.getInt(c.getColumnIndex("id"))
                val nome = c.getString(c.getColumnIndex("nome"))
                val disciplinas = c.getString(c.getColumnIndex("disciplinas"))
                val img = c.getString(c.getColumnIndex("img"))
                lista.add(Professor(id, nome, disciplinas, img))
            }while (c.moveToNext())
        }

        return lista
    }

    fun get(index: Int): Professor?{
        val colunas = arrayOf("id", "nome", "disciplinas", "img")
        val where = "id = ?"
        val pwhere = arrayOf(index.toString())

        val c = this.banco.readableDatabase.query("professor", colunas, where, pwhere, null, null, null)
        c.moveToFirst()

        if(c.count >0){
            val id = c.getInt(c.getColumnIndex("id"))
            val nome = c.getString(c.getColumnIndex("nome"))
            val disciplinas = c.getString(c.getColumnIndex("disciplinas"))
            val img = c.getString(c.getColumnIndex("img"))
            return Professor(id, nome, disciplinas, img)
        }

        return null
    }

    fun update(p:Professor){
        val where = "id = ?"
        val pwhere = arrayOf(p.id.toString())
        val cv = ContentValues()
        cv.put("id", p.id)
        cv.put("nome", p.nome)
        cv.put("disciplinas", p.disciplinas)
        cv.put("img", p.img)

        this.banco.writableDatabase.update("professor", cv, where, pwhere)
    }

    // delete
    fun delete(id: Int){
        val where = "id = ?"
        val pwhere = arrayOf(id.toString())

        this.banco.writableDatabase.delete("professor", where, pwhere)
    }

    fun delete(){
        this.banco.writableDatabase.execSQL("DELETE FROM Professor")
    }
}
