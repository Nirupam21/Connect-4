package com.example.connect4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    var gamestate = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    var gameisactive = true
    var winningpositions2 = arrayOf(
        arrayOf(0,1,2,3,4), arrayOf(1,2,3,4,5), arrayOf(2,3,4,5,6),
        arrayOf(7,8,9,10,11), arrayOf(8,9,10,11,12), arrayOf(9,10,11,12,13),
        arrayOf(14,15,16,17,18), arrayOf(15,16,17,18,19), arrayOf(16,17,18,19,20),
        arrayOf(21,22,23,24,25), arrayOf(22,23,24,25,26), arrayOf(23,24,25,26,27),
        arrayOf(28,29,30,31,32), arrayOf(29,30,31,32,33), arrayOf(30,31,32,33,34),

        arrayOf(0,7,14,21,28), arrayOf(1,8,15,22,29), arrayOf(2,9,16,23,30), arrayOf(3,10,17,24,31),
        arrayOf(4,11,17,25,32), arrayOf(5,12,19,26,33), arrayOf(6,13,20,27,34),

        arrayOf(0,8,16,24,32), arrayOf(1,9,17,25,33), arrayOf(2,10,18,26,34),
        arrayOf(4,10,16,22,28), arrayOf(5,11,17,23,29), arrayOf(6,12,18,24,30)

    )
    var activeplayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun dropcoin(view: View) {

        val counter = view as ImageView

        //Log.i("Tag", counter.getTag().toString());
        var tappedcounter = counter.tag.toString().toInt()

        if (gameisactive) {

            if (gamestate[tappedcounter] != 0)

                Toast.makeText(this, "Pocket already occupied", Toast.LENGTH_SHORT).show()

            else if (tappedcounter >= 28 || gamestate[tappedcounter + 7] == 1 || gamestate[tappedcounter + 7] == 2)  {

                gamestate[tappedcounter] = activeplayer
                counter.translationY = -1500f

                activeplayer = if (activeplayer == 1) {
                    counter.setImageResource(R.drawable.red)
                    2
                } else {
                    counter.setImageResource(R.drawable.yellow)
                    1
                }
                counter.animate().translationYBy(1500f).duration = 300

                for (winningposition in winningpositions2) {

                    var winner = ""
                    val result = findViewById<TextView>(R.id.results)
                    val btn = findViewById<Button>(R.id.resbtn)
                    val hbtn = findViewById<Button>(R.id.homebtn)
                    val winlogo = findViewById<ImageView>(R.id.iv)

                    if (gamestate[winningposition[0]] == gamestate[winningposition[1]] && gamestate[winningposition[1]] == gamestate[winningposition[2]] && gamestate[winningposition[2]] == gamestate[winningposition[3]] && gamestate[winningposition[3]] == gamestate[winningposition[4]] && gamestate[winningposition[0]] != 0) {

                        gameisactive = false
                        if (gamestate[winningposition[0]] == 1) {
                            winner = "Red is the winner"
                        } else {
                            winner = "Yellow is the winner"
                        }

                        result.setText(winner)
                        winlogo.setImageResource(R.drawable.winner)
                        btn.visibility = View.VISIBLE
                        hbtn.visibility = View.VISIBLE

                    }
                }
            } else Toast.makeText(this, "You can't place your coin here", Toast.LENGTH_SHORT).show()
        }

    }
    fun playAgain(view: View) {

        val intent = Intent(this, MainActivity::class.java).apply {

        }
        startActivity(intent)

    }

    fun home(view: View) {

        val intent = Intent(this, FirstActivity::class.java).apply {

        }
        startActivity(intent)

    }
}