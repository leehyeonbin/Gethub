package com.example.gethub

import com.example.gethub.DTO.UserInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    // ID 받아오기
    @GET("users/${User.userid}/")
    fun getUserInfo(

    ): retrofit2.Call<UserInfo>
}