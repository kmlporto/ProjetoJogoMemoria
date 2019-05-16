package com.example.projetojododamemoria

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var daoProf:ProfessorDAO
    private lateinit var btListProf: Button
    private lateinit var btGerarJogo: Button

    val LISTAR = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        daoProf = ProfessorDAO(this)
        carregarBanco()
        this.btListProf = findViewById(R.id.btLstProf)
        this.btListProf.setOnClickListener({chamarLisProf(it)})


        this.btGerarJogo = findViewById(R.id.btGerarJogo)
        this.btGerarJogo.setOnClickListener({chamarJogo(it)})
    }

    private fun carregarBanco() {
        daoProf.insert(Professor("Alex Sandro da Cunha Rego", "Algoritmo e Prog. Estrut., Banco de Dados II", "alex" ))
        daoProf.insert(Professor("Alana Marques de Morais", "BD 2, Análise e Proj. de Sist., Padrões de Projeto de Software", "alana"))
        daoProf.insert(Professor("Candido Jose Ramos do Egypto", "Algoritmo e Prog. Estrut., Banco de Dados I", "candido"))
        daoProf.insert(Professor("Crishane Azevedo Freire", "Algoritmo e Prog. Estrut.", "crishane"))
        daoProf.insert(Professor("Damires Yluska de Souza Fernandes", "Banco de Dados II", "damires"))
        daoProf.insert(Professor("Denio Mariz Timoteo de Sousa", "Segurança de Dados", "denio"))
        daoProf.insert(Professor("Edemberg Rocha da Silva", "Algoritmo e Prog. Estrut.", "edemberg"))
        daoProf.insert(Professor("Fausto Veras Maranhao Ayres", "Prog. Orientada a Objetos, Persistência de Objetos", "fausto"))
        daoProf.insert(Professor("Francisco Petronio Alencar de Medeiros", "Interação Humano-Computador", "petronio"))
        daoProf.insert(Professor("Frederico Costa Guedes Pereira", "Fund. Computação, Programação para Web II", "fred"))
        daoProf.insert(Professor("Giovanni Loureiro Franca de Mendonca", "Fund. Computação, ", "giovanni"))
        daoProf.insert(Professor("Heremita Brasileiro Lira", "Comércio Eletrônico, Gerência de Projetos de Software", "heremita"))
        daoProf.insert(Professor("Jose Gomes Quaresma Filho", "Fundamentos de Redes", "zefilho"))
        daoProf.insert(Professor("Pryscilla Marcili Dora", "Fundamentos de Redes", "pryscilla"))
        daoProf.insert(Professor("Francisco Dantas Nobre Neto", "Linguagem de Marcação", "francisco"))
        daoProf.insert(Professor("Thiago Jose Marques Moura", "Linguagem de Marcação, Estrutura de Dados", "thiago"))
        daoProf.insert(Professor("Marcus Vinicius Delgado Varandas", "Legislação Social, Empreendedorismo SI", "varandas"))
        daoProf.insert(Professor("Nilton Freire Santos", "Banco de Dados I", "nilton"))
        daoProf.insert(Professor("Lafayette Batista Melo", "Fund. Metodologia, Métod. e Téc. de Pesquisa", "lafayette"))
        daoProf.insert(Professor("Luiz Carlos Rodrigues Chaves", "Linguagem de Script, Programação para Web I", "luiz"))
        daoProf.insert(Professor("Leonidas Francisco de Lima Junior", "Protoc. de Redes", "leonidas"))
        daoProf.insert(Professor("Gustavo Wagner Diniz Mendes", "Sist. Operacionais", "gustavo"))
        daoProf.insert(Professor("Valeria Maria Bezerra Cavalcanti Maciel", "Padrões de Proj. de Software, Prog. para Disp. Móveis", "valeria"))

    }

    private fun chamarLisProf(view:View) {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

    fun chamarJogo(view: View){

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if(resultCode == Activity.RESULT_OK && requestCode == LISTAR){
//
//        }
//    }
    
}
