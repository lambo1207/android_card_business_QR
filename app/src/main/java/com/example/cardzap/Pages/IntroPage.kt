package com.example.cardzap.Pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.cardzap.R

class IntroPage : AppCompatActivity() {

    lateinit var btnLogin: Button
    lateinit var btnSignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_page)

        btnLogin = findViewById(R.id.btnLogin)
        btnSignup = findViewById(R.id.btnSignUp)

        btnLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnSignup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}