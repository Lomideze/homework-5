package com.example.homework5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework5.databinding.ActivitySecondRegisterBinding

class SecondRegisterActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySecondRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondRegisterBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val inputName = viewBinding.inputName
        val backBtn = viewBinding.backBtn
        val sigUpBtn = viewBinding.signUpBtn
        val privacyPolicyBtn = viewBinding.privacyPolicyBtn
        val termsOfServiceBtn = viewBinding.termsOfServiceBtn

        backBtn.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
        sigUpBtn.setOnClickListener {
            val name = inputName.text.toString()
            val intent = Intent(this, MainPageActivity::class.java)
            intent.putExtra("NAME", name)

            startActivity(intent)
            finish()
        }
        privacyPolicyBtn.setOnClickListener {
            Toast.makeText(this, "you agree privacy policy", Toast.LENGTH_SHORT).show()
        }
        termsOfServiceBtn.setOnClickListener {
            Toast.makeText(this, "you agree terms of service", Toast.LENGTH_SHORT).show()
        }
    }
}