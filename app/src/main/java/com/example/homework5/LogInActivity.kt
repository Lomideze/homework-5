package com.example.homework5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework5.databinding.ActivityLogInBinding
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityLogInBinding

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        mAuth = FirebaseAuth.getInstance()

        val backBtn = viewBinding.backBtn
        val logInBtn = viewBinding.logInBtn
        val inputEmail = viewBinding.inputEmail
        val inputPassword = viewBinding.inputPassword


        backBtn.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }

        logInBtn.setOnClickListener {

            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Error !!!", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, MainPageActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "user is not valid!!!", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }

    }
}