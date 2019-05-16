package com.example.projetojododamemoria

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import ImageAdapter

class MemoryGame : AppCompatActivity() {
    //var professores: ArrayList<Professor> = intent.getSerializableExtra("dao") as ArrayList<Professor>
    lateinit var gvImagens: GridView
    var card1: ImageView? = null
    var card2: ImageView? = null
    private var countPair: Int = 0
    val cards= arrayOf(
        R.drawable.alana,
        R.drawable.alex,
        R.drawable.candido,
        R.drawable.crishane,
        R.drawable.damires,
        R.drawable.denio,
        R.drawable.edemberg,
        R.drawable.fausto
    ).toList().shuffled()
    var pos = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7).toList().shuffled()
    var currentPos = -1
    var acert: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory_game)

        this.gvImagens = findViewById(R.id.gvImagens)
        val imageAdapter= ImageAdapter(this)
        gvImagens.adapter = imageAdapter

        var currentPlay = 0
        Log.i("Jogo", "pos:${pos}")

        gvImagens.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                //val handler = Handler()
                view as ImageView
                Log.i("Jogo", "currentPos:${currentPos} currentPlay${currentPlay}")
                if (currentPos < 0) {
                    if (!acert){
                        card1?.setImageResource(R.drawable.hidden)
                        card2?.setImageResource(R.drawable.hidden)
                    }
                    currentPos = position
                    card1 = view
                    (view as ImageView?)?.setImageResource(cards[pos[position]])
                }
                else {
                    card2 = view
                    card2?.setImageResource(cards[pos[position]])

                    if(pos[currentPos] != pos[position]){
                        acert = false
                    }
                    else{
                        (view as ImageView?)?.setImageResource(cards[pos[position]])
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
