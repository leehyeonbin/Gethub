package com.example.gethub.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.gethub.model.UserInfo
import com.example.gethub.model.User
import com.example.gethub.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var mbinding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        val userinfo = UserInfo

        mbinding.followers.text = userinfo?.followers.toString()
        mbinding.following.text = userinfo?.following.toString()
        mbinding.userid.text = User.userid
        mbinding.company.text = userinfo?.company.toString()
        mbinding.name.text = userinfo?.name.toString()
        User.URl = userinfo?.html_url.toString()
        Glide.with()
            .load("${userinfo?.avatar_url.toString()}")
            .into(mbinding.githubLog)


        mbinding.githubLog.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("${User.URl}")
            startActivity(intent)
        }

        mbinding.backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(0, 0)
            finish()
        }
    }
}