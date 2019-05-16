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
    var professores = intent.getSerializableExtra("dao")
    lateinit var gvImagens: GridView
    var curView: ImageView? = null
    private var countPair: Int = 0
    val cards= arrayOf(
        R.drawable.img1,
        R.drawable.img8,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5,
        R.drawable.img6,
        R.drawable.img7
    ).toList().shuffled()
    var pos = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7).toList().shuffled()
    var currentPos = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.gvImagens = findViewById(R.id.gvImagens)
        val imageAdapter= ImageAdapter(this)
        gvImagens.adapter = (imageAdapter)

        var currentPlay = 0
        Log.i("Jogo", "pos:${pos}")
        gvImagens.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                //val handler = Handler()
                view as ImageView
                Log.i("Jogo", "currentPos:${currentPos} currentPlay${currentPlay}")
                if (currentPos < 0) {
                    currentPos = position
                    curView = view
                    (view as ImageView?)?.setImageResource(cards[pos[position]])
                }
                else {
                    if (currentPos == position) {
                        currentPlay = 1
                    }

                    else if(pos[currentPos] != pos[position]){
                        curView?.setImageResource(R.drawable.hidden)

                        currentPlay = 2
                    }
                    else{
                        (view as ImageView?)?.setImageResource(cards[pos[position]])
                        countPair++
                        currentPlay = 2
                        view.isClickable = true
                        curView?.isClickable = true

                        if(countPair==8)
                        {
                            Toast.makeText(applicationContext,"You win", Toast.LENGTH_LONG).show()
                        }
                    }
                    if(currentPlay !=1){
                        currentPos = -1
                    }
                }
            }

        }
    }
}
