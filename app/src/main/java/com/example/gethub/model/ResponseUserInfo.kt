package com.example.gethub.model

data class ResponseUserInfo(
    var avatar_url: String?,
    var userId: String?,
    var followers: Int?,
    var following: Int?,
    var company: String?,
    var html_url: String?,
    var name: String
)