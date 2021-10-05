package com.example.gethub.model

data class UserInfo(
    val avatar_url : String?,
    val userId : String?,
    val followers : Int?,
    val following : Int?,
    val company : String?,
    val html_url : String?,
    val name : String?
)