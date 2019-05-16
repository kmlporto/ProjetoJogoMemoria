package com.example.projetojododamemoria

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class ListActivity : AppCompatActivity() {
    private lateinit var lvProfessores: ListView
    private lateinit var dao: ProfessorDAO
    val fotos= arrayOf(
        R.drawable.alana,
        R.drawable.alex,
        R.drawable.candido,
        R.drawable.crishane,
        R.drawable.damires,
        R.drawable.denio,
        R.drawable.edemberg,
        R.drawable.fausto,
        R.drawable.francisco,
        R.drawable.fred,
        R.drawable.giovanni,
        R.drawable.gustavo,
        R.drawable.heremita,
        R.drawable.juliana,
        R.drawable.lafayette,
        R.drawable.leonidas,
        R.drawable.nilton,
        R.drawable.petronio,
        R.drawable.pryscilla,
        R.drawable.thiago,
        R.drawable.valeria,
        R.drawable.varandas,
        R.drawable.zefilho
    ).toList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        dao = ProfessorDAO(this)

        this.lvProfessores = findViewById(R.id.lvProfessores)
        var adapter = ProfessorAdapter(this, dao.get())
        lvProfessores.adapter = adapter
    }


    inner class ProfessorAdapter(private val context: Context,
                                 private val listProfs: ArrayList<Professor> = dao.get()) :
        BaseAdapter() {

        private val inflater: LayoutInflater
                = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


        @SuppressLint("ResourceType")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowView = inflater.inflate(R.layout.activity_professor_detail, parent, false)

            //pegando cada campo do xml que criei para mostrar detalhes de cada professor
            val nomeTextView = rowView.findViewById(R.id.tvNome) as TextView
            val disciplinasTextView = rowView.findViewById(R.id.tvDisciplinas) as TextView
            val fotoImageView = rowView.findViewById(R.id.tvImagem) as ImageView

            var professor = listProfs[position]
            nomeTextView.text = professor.nome
            disciplinasTextView.text = professor.disciplinas
            //var nomeImagem = professor.img
            //var nomeImagem = img1
            //var imagem: ImageView
            //imagem = findViewById(R.drawable.img1)
            fotoImageView.setImageResource(R.drawable.alana)

            return rowView
        }

        override fun getItem(position: Int): Any {
            return listProfs[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listProfs.size
        }
    }

}
