package com.example.gethub.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.gethub.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var mbinding : ActivitySplashBinding
    val time : Long = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mbinding.root)
        Handler().postDelayed({
            intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish() // 현재 액티비티 종료
        },time)
    }
}