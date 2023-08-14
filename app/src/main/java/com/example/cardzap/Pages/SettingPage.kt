package com.example.cardzap.Pages

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.cardzap.R
import com.google.firebase.auth.FirebaseAuth

class SettingPage : AppCompatActivity() {

    private lateinit var ibBackSetting: ImageButton
    private lateinit var btnLogout: Button
    private lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_page)

        ibBackSetting = findViewById(R.id.ib_backSetting)
        btnLogout = findViewById(R.id.btnLogout)
        btnDelete = findViewById(R.id.btnDelete)


        ibBackSetting.setOnClickListener { finish() }

        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, IntroPage::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }


    }

}