package com.example.projetojododamemoria

import android.app.Activity
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
    val JOGO = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        daoProf = ProfessorDAO(this)
        //carregarBanco()
        this.btListProf = findViewById(R.id.btLstProf)
        this.btListProf.setOnClickListener({chamarLisProf(it)})


        this.btGerarJogo = findViewById(R.id.btGerarJogo)
        this.btGerarJogo.setOnClickListener({chamarJogo(it)})
    }

    private fun carregarBanco() {
        daoProf.insert(Professor("Alex Sandro da Cunha Rego", "Algoritmo e Prog. Estrut., Banco de Dados II", R.drawable.alex ))
        daoProf.insert(Professor("Alana Marques de Morais", "BD 2, Análise e Proj. de Sist., Padrões de Projeto de Software",  R.drawable.alana))
        daoProf.insert(Professor("Candido Jose Ramos do Egypto", "Algoritmo e Prog. Estrut., Banco de Dados I",  R.drawable.candido))
        daoProf.insert(Professor("Crishane Azevedo Freire", "Algoritmo e Prog. Estrut.",  R.drawable.crishane))
        daoProf.insert(Professor("Damires Yluska de Souza Fernandes", "Banco de Dados II",  R.drawable.damires))
        daoProf.insert(Professor("Denio Mariz Timoteo de Sousa", "Segurança de Dados",  R.drawable.denio))
        daoProf.insert(Professor("Edemberg Rocha da Silva", "Algoritmo e Prog. Estrut.",  R.drawable.edemberg))
        daoProf.insert(Professor("Fausto Veras Maranhao Ayres", "Prog. Orientada a Objetos, Persistência de Objetos",  R.drawable.fausto))
        daoProf.insert(Professor("Francisco Petronio Alencar de Medeiros", "Interação Humano-Computador",  R.drawable.petronio))
        daoProf.insert(Professor("Frederico Costa Guedes Pereira", "Fund. Computação, Programação para Web II",  R.drawable.fred))
        daoProf.insert(Professor("Giovanni Loureiro Franca de Mendonca", "Fund. Computação, ",  R.drawable.giovanni))
        daoProf.insert(Professor("Heremita Brasileiro Lira", "Comércio Eletrônico, Gerência de Projetos de Software",  R.drawable.heremita))
        daoProf.insert(Professor("Jose Gomes Quaresma Filho", "Fundamentos de Redes",  R.drawable.zefilho))
        daoProf.insert(Professor("Pryscilla Marcili Dora", "Fundamentos de Redes",  R.drawable.pryscilla))
        daoProf.insert(Professor("Francisco Dantas Nobre Neto", "Linguagem de Marcação",  R.drawable.francisco))
        daoProf.insert(Professor("Thiago Jose Marques Moura", "Linguagem de Marcação, Estrutura de Dados",  R.drawable.thiago))
        daoProf.insert(Professor("Marcus Vinicius Delgado Varandas", "Legislação Social, Empreendedorismo SI",  R.drawable.varandas))
        daoProf.insert(Professor("Nilton Freire Santos", "Banco de Dados I",  R.drawable.nilton))
        daoProf.insert(Professor("Lafayette Batista Melo", "Fund. Metodologia, Métod. e Téc. de Pesquisa",  R.drawable.lafayette))
        daoProf.insert(Professor("Luiz Carlos Rodrigues Chaves", "Linguagem de Script, Programação para Web I",  R.drawable.luiz))
        daoProf.insert(Professor("Leonidas Francisco de Lima Junior", "Protoc. de Redes",  R.drawable.leonidas))
        daoProf.insert(Professor("Gustavo Wagner Diniz Mendes", "Sist. Operacionais",  R.drawable.gustavo))
        daoProf.insert(Professor("Valeria Maria Bezerra Cavalcanti Maciel", "Padrões de Proj. de Software, Prog. para Disp. Móveis",  R.drawable.valeria))

    }

    private fun chamarLisProf(view:View) {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

    fun chamarJogo(view: View){
        val intent = Intent(this, MemoryGame::class.java)
        intent.putExtra("dao", daoProf.get())
        startActivityForResult(intent, JOGO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK && requestCode == JOGO){

        }
    }
    
}
