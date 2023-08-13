package com.example.cardzap.Pages

import android.R
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.cardzap.databinding.ActivityNewCardBinding
import com.example.cardzap.databinding.CustomToolbarBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import yuku.ambilwarna.AmbilWarnaDialog

class NewCard : AppCompatActivity() {

    private lateinit var binding: ActivityNewCardBinding
    private lateinit var customBinding: CustomToolbarBinding

    private lateinit var textGenerate: String
    private var selectedColor: Int = Color.BLACK

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        customBinding = CustomToolbarBinding.bind(binding.root)

        customBinding.ibBack.setOnClickListener {
            finish()
        }

        binding.tvChooseColorText.setOnClickListener {
            callChangeColor(it, this)
        }

        binding.tvChooseColorCard.setOnClickListener {
            callChangeColor(it, this)
            it.setBackgroundColor(ContextCompat.getColor(this, R.color.holo_red_dark))
        }

        customBinding.btnSave.setOnClickListener {
            generateQRCode()
        }

    }

    private fun generateQRCode() {

        val fields = listOf(
            binding.edtFirstName,
            binding.edtLastName,
            binding.edtCompany,
            binding.edtDepartment,
            binding.edtEmail,
            binding.edtPhoneNumber,
            binding.edtFacebook,
            binding.edtInstagram,
            binding.edtLinkedIn,
            binding.edtWebsite,
            binding.edtCardName
        )

        var textGenerate = ""

        fields.forEach { editText ->
            val value = editText.text.toString()
            if (value.isNotBlank()) {
                textGenerate += "$value:"
            }
        }

        if (textGenerate.isNotEmpty()) {
            textGenerate = textGenerate.substring(0, textGenerate.length - 1)
        }
        else{
            textGenerate = "Error!!!"
        }

        val multiFormatWriter = MultiFormatWriter()

        try {
            val bitMatrix = multiFormatWriter.encode(
                textGenerate,
                BarcodeFormat.QR_CODE,
                800,
                800
            )

            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.createBitmap(bitMatrix)

            binding.ivQrCode.setImageBitmap(bitmap)

        } catch (e: Exception) {
            throw RuntimeException(e)
        }

        // Navigator Home
    }

    private fun callChangeColor(it: View, context: NewCard) {
        val colorPicker = AmbilWarnaDialog(this, selectedColor, object : AmbilWarnaDialog.OnAmbilWarnaListener {
            override fun onCancel(dialog: AmbilWarnaDialog?) {
                //
            }

            override fun onOk(dialog: AmbilWarnaDialog?, color: Int) {
                try {
                    selectedColor = color
                    val colorHex = String.format("#%06X", 0xFFFFFF and selectedColor)
                    it.setBackgroundColor(selectedColor)
                }
                catch (e: Exception){
                    Log.i("TAG", e.toString())
                }
            }
        })
        colorPicker.show()
    }


}