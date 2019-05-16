package com.example.projetojododamemoria

class Professor {
    var id: Int
    var nome: String
    var disciplinas: String
    var img: Int

    constructor(id: Int, nome:String, disciplinas:String, img: Int){
        this.id = id
        this.nome = nome
        this.disciplinas = disciplinas
        this.img = img
    }

    constructor(nome:String, disciplinas: String, img: Int){
        this.id = -1
        this.nome = nome
        this.disciplinas = disciplinas
        this.img = img
    }

    override fun toString():String{
        return "Professor:${nome} - disciplinas:${disciplinas}"
    }
}