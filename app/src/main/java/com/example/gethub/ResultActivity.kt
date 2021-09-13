package com.example.gethub

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.gethub.DTO.UserInfo
import com.example.gethub.databinding.ActivityResultBinding
import retrofit2.Call
import retrofit2.Response

class ResultActivity : AppCompatActivity() {

    private lateinit var mbinding : ActivityResultBinding
    val TAG : String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        RetrofitBuilder.api.getUserInfo(userid = User.userid).enqueue(object : retrofit2.Callback<UserInfo> {
            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                val userinfo = response.body()
                mbinding.followers.text = userinfo?.followers.toString()
                mbinding.following.text = userinfo?.following.toString()
                mbinding.userid.text = User.userid
                mbinding.company.text = userinfo?.company.toString()
                mbinding.name.text = userinfo?.name.toString()
                User.URl = userinfo?.html_url.toString()
                Glide.with(this@ResultActivity)
                    .load("${userinfo?.avatar_url.toString()}")
                    .into(mbinding.githubLog)
                Log.d(TAG,"onResponse: 유저아이디: ${userinfo?.userId}, 팔로워 : ${userinfo?.followers}, 팔로잉 : ${userinfo?.following}," +
                        "회사 : ${userinfo?.company}, 깃허브 링크 : ${User.URl}")
            }

            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                Log.d("error", t.message.toString())
            }
        })

        mbinding.githubLog.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("${User.URl.toString()}")
            startActivity(intent)
        }

        mbinding.backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}