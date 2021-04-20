package com.example.connect4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var gamestate = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    var gameisactive = true
    var winningpositions = arrayOf(
            intArrayOf(0, 1, 2, 3), intArrayOf(1, 2, 3, 4), intArrayOf(2, 3, 4, 5), intArrayOf(3, 4, 5, 6), intArrayOf(7, 8, 9, 10), intArrayOf(8, 9, 10, 11), intArrayOf(9, 10, 11, 12), intArrayOf(10, 11, 12, 13), intArrayOf(14, 15, 16, 17), intArrayOf(15, 16, 17, 18), intArrayOf(16, 17, 18, 19), intArrayOf(17, 18, 19, 20), intArrayOf(21, 22, 23, 24), intArrayOf(22, 23, 24, 25), intArrayOf(23, 24, 25, 26), intArrayOf(24, 25, 26, 27), intArrayOf(28, 29, 30, 31), intArrayOf(29, 30, 31, 32), intArrayOf(30, 31, 32, 33), intArrayOf(31, 32, 33, 34), intArrayOf(0, 7, 14, 21), intArrayOf(7, 14, 21, 28), intArrayOf(1, 8, 15, 22), intArrayOf(8, 15, 22, 29), intArrayOf(2, 9, 16, 23), intArrayOf(9, 16, 23, 30), intArrayOf(3, 10, 17, 24), intArrayOf(10, 17, 24, 31), intArrayOf(4, 11, 18, 25), intArrayOf(11, 18, 25, 32), intArrayOf(5, 12, 19, 26), intArrayOf(12, 19, 26, 33), intArrayOf(6, 13, 20, 27), intArrayOf(13, 20, 27, 34), intArrayOf(7, 15, 23, 31), intArrayOf(0, 8, 16, 24), intArrayOf(8, 16, 24, 32), intArrayOf(1, 9, 17, 25), intArrayOf(9, 17, 25, 33), intArrayOf(2, 10, 18, 26), intArrayOf(10, 18, 26, 34), intArrayOf(3, 11, 19, 27),
            intArrayOf(3,9,15,21),
            intArrayOf(4,10,16,22), intArrayOf(10,16,22,28),
            intArrayOf(5,11,17,23), intArrayOf(11,17,23,29),
            intArrayOf(6,12,18,24), intArrayOf(12,18,24,30),
            intArrayOf(13,19,25,31)
    )
    var activeplayer = 1

    fun dropcoin(view: View) {

        val counter = view as ImageView

        //Log.i("Tag", counter.getTag().toString());
        val tappedcounter = counter.tag.toString().toInt()

        if (gameisactive) {

            if (gamestate[tappedcounter] != 0) Toast.makeText(this, "Pocket already occupied", Toast.LENGTH_SHORT).show()

            else if (tappedcounter >= 28 || gamestate[tappedcounter + 7] == 1 || gamestate[tappedcounter + 7] == 2) {

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

                for (winningposition in winningpositions) {

                    var winner = ""
                    val result = findViewById<TextView>(R.id.results)
                    val btn = findViewById<Button>(R.id.resbtn)
                    val hbtn = findViewById<Button>(R.id.homebtn)
                    val winlogo = findViewById<ImageView>(R.id.iv)

                    if (gamestate[winningposition[0]] == gamestate[winningposition[1]] && gamestate[winningposition[1]] == gamestate[winningposition[2]] && gamestate[winningposition[2]] == gamestate[winningposition[3]] && gamestate[winningposition[0]] != 0) {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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