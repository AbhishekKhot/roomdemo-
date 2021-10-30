package com.example.Noteapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.Noteapp.R

class SplashActivity : AppCompatActivity() {
    private val SPLASHTIMEOUT:Long = 3000 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        Handler().postDelayed({
            startActivity(Intent(this,NoteActivity::class.java))
            finish()
        }, SPLASHTIMEOUT)

    }
}