package com.example.cardzap.Pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cardzap.R
import com.example.cardzap.databinding.ActivitySignupBinding
import com.example.cardzap.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.signupBtnSignUp.setOnClickListener {
            val email = binding.signupEmail.text.toString()
            val pass = binding.signupPassword.text.toString()
            val confirmPass = binding.signupConfirmpass.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()){
                if (pass == confirmPass){
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener{authResult ->
                        if (authResult.isSuccessful){
                            val user = authResult.result?.user
                            val uid = user?.uid ?: ""

                            val newUser = User(id = uid, email = email)

                            val db = FirebaseFirestore.getInstance()
                            db.collection("User").document(uid).set(newUser).addOnSuccessListener {
                                startActivity(Intent(this, LoginActivity::class.java))
                            }.addOnFailureListener{
                                exception -> Toast.makeText(this, exception.toString(),Toast.LENGTH_LONG).show()
                            }
                        } else{
                            Toast.makeText(this, authResult.exception.toString(),Toast.LENGTH_LONG).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Passwork and Passwork confirm not match !",Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "No anyfield is empty !",Toast.LENGTH_LONG).show()
            }
        }
    }
}