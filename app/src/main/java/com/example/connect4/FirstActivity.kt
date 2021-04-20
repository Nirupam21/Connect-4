package com.example.connect4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
    }

    fun cnct4(view: View) {

        val intent = Intent(this, MainActivity::class.java).apply {

        }
        startActivity(intent)

    }
    fun cnct5(view: View) {

        val intent = Intent(this, MainActivity2::class.java).apply {

        }
        startActivity(intent)

    }

}