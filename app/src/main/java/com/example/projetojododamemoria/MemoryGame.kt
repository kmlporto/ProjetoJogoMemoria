package com.example.projetojododamemoria

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import ImageAdapter

class MemoryGame : AppCompatActivity() {
    lateinit var professores: ArrayList<Professor>
    lateinit var gvImagens: GridView
    lateinit var profRandom: List<Professor>
    var card1: ImageView? = null
    var card2: ImageView? = null
    var countPair: Int = 0

    var pos = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7).toList().shuffled()
    var currentPos = -1
    var acert: Boolean = false
    var erro = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory_game)

        this.professores = intent.getSerializableExtra("dao") as ArrayList<Professor>
        this.professores.shuffle()
        this.profRandom = this.professores.subList(0,8)

        var cardprof: List<Int>
        cardprof= this.profRandom.map{ professor -> professor.img }

        this.gvImagens = findViewById(R.id.gvImagens)
        val imageAdapter= ImageAdapter(this)
        gvImagens.adapter = imageAdapter


        gvImagens.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                view as ImageView
                if (currentPos < 0) {
                    if (!acert){
                        card1?.setImageResource(R.drawable.hidden)
                        card2?.setImageResource(R.drawable.hidden)
                    }
                    currentPos = position
                    card1 = view
                    (view as ImageView?)?.setImageResource(cardprof[pos[position]])
                }
                else {
                    card2 = view
                    card2?.setImageResource(cardprof[pos[position]])

                    if(pos[currentPos] != pos[position]){
                        acert = false
                        erro++
                    }
                    else{
                        (view as ImageView?)?.setImageResource(cardprof[pos[position]])
                        acert = true
                        countPair++
                        view.isClickable = true
                        card1?.isClickable = true

                        if(countPair==8){
                            Toast.makeText(applicationContext,"You win", Toast.LENGTH_LONG).show()
                        }
                    }
                    currentPos = -1
                }
            }
        }
    }
}
