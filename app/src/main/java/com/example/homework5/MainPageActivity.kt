package com.example.homework5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework5.databinding.ActivityMainPageBinding
import com.google.firebase.auth.FirebaseAuth

class MainPageActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainPageBinding

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        mAuth = FirebaseAuth.getInstance()

        val logOutBtn = viewBinding.logOutBtn
        val nameText = viewBinding.nameText

        val extras = intent.extras
        var name = ""

        if (extras != null) {
            name = extras.getString("NAME", "")
        }
        nameText.text = name

        logOutBtn.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}