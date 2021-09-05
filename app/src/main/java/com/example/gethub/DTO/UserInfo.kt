package com.example.gethub.DTO

data class UserInfo(
    val userId : String,
    val followers : Int,
    val following : Int,
    val company : String,
    val html_user : String
)
