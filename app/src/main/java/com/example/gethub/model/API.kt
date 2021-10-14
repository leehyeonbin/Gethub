package com.example.gethub.model

import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    // ID 받아오기
    @GET("users/{userid}")

    fun getUserInfo(@Path("userid")userid:String): retrofit2.Call<ResponseUserInfo>
}