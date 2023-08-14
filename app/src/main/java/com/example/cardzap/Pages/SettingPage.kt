package com.example.cardzap.Pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.cardzap.R

class SettingPage : AppCompatActivity() {

    private lateinit var ibBackSetting: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_page)

        ibBackSetting = findViewById(R.id.ib_backSetting)
        ibBackSetting.setOnClickListener { finish() }
    }
}