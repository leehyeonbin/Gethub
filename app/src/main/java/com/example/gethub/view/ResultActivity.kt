package com.example.gethub.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.gethub.model.User
import com.example.gethub.databinding.ActivityResultBinding
import com.example.gethub.model.UserInfo
import com.example.gethub.model.UserInfo.avatar_url
import com.example.gethub.model.UserInfo.followers
import com.example.gethub.model.UserInfo.following
import com.example.gethub.model.UserInfo.html_url
import com.example.gethub.model.UserInfo.name
import com.example.gethub.viewmodel.MainViewModel

class ResultActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityResultBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


      //  val userinfo = UserInfo
   /*     viewModel.response.apply {
            mBinding.followers.text = value?.followers.toString()
            mBinding.following.text = value?.following.toString()
            //mBinding.userid.text = User.userid
            mBinding.company.text = value?.company.toString()
            mBinding.name.text = value?.name.toString()
            User.URl = value?.html_url.toString()
        }*/
        mBinding.followers.text = followers.toString()
        mBinding.following.text = following.toString()
       // mBinding.userid.text = User.userid
        mBinding.company.text = UserInfo.company.toString()
        mBinding.name.text = name.toString()
        User.URl = html_url.toString()
        Glide.with(this)
            .load("${avatar_url.toString()}")
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