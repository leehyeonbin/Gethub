package com.example.gethub.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.gethub.model.User
import com.example.gethub.databinding.ActivityResultBinding
import com.example.gethub.model.UserInfo

class ResultActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val userinfo = UserInfo

        mBinding.followers.text = userinfo.followers.toString()
        mBinding.following.text = userinfo?.following.toString()
        mBinding.userid.text = User.userid
        mBinding.company.text = userinfo?.company.toString()
        mBinding.name.text = userinfo?.name.toString()
        User.URl = userinfo?.html_url.toString()
        Glide.with(this)
            .load("${userinfo?.avatar_url.toString()}")
            .into(mBinding.githubLog)


        mBinding.githubLog.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("${User.URl}")
            startActivity(intent)
        }

        mBinding.backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(0, 0)
            finish()
        }
    }
}