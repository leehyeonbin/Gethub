package com.example.gethub

import com.example.gethub.DTO.UserInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    // ID 받아오기
    @GET("users/{userid}")

    fun getUserInfo(@Path("userid")userid:String): retrofit2.Call<UserInfo>
}