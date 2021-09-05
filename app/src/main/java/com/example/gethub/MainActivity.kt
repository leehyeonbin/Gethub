package com.example.gethub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gethub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mbinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        mbinding.submitBtn.setOnClickListener {
            val userid = mbinding.inputUserEt.text.toString().trim()

        }
    }
}