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
            var fotoProfessor = professor.img

            fotoImageView.setImageResource(fotoProfessor)

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
