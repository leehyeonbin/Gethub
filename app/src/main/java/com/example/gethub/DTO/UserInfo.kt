package com.example.gethub.DTO

import android.widget.ImageView

data class UserInfo(
    val avatar_url : ImageView,
    val userId : String,
    val followers : Int,
    val following : Int,
    val company : String,
    val html_url : String,
    val name : String
)
