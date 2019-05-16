package com.example.projetojododamemoria

import java.io.Serializable

class ListaProfessores: Serializable {
    private lateinit var professores: ArrayList<Professor>

    constructor(professores: ArrayList<Professor>){
        this.professores = professores
    }
}