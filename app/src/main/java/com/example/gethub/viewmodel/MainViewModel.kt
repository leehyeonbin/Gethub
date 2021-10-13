package com.example.gethub.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gethub.model.RetrofitBuilder
import com.example.gethub.model.User
import com.example.gethub.model.UserInfo
import retrofit2.Call
import retrofit2.Response

class MainViewModel : ViewModel(){

    private var id = ""

    //LiveData
    //값이 변경되는 경우 MutableLiveData 로 선언한다.
    val _load = MutableLiveData<Int>()

    val load : LiveData<Int> = _load

    val TAG = "로그"

    init {
        _load.value = 0
    }

    fun setid (newid : String) {
        id = newid
    }

    fun getId() = id

    fun setloadbutton () {
        RetrofitBuilder.api.getUserInfo(userid = User.userid).enqueue(object : retrofit2.Callback<UserInfo> {
            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                val userinfo = response.body()
                UserInfo.avatar_url = userinfo?.avatar_url
                UserInfo.company= userinfo?.company
                UserInfo.followers = userinfo?.followers
                UserInfo.following = userinfo?.following
                UserInfo.html_url = userinfo?.html_url
                UserInfo.name = userinfo!!.name
                UserInfo.userId = userinfo!!.name

            }

            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                Log.d("error", t.message.toString())
            }
        })
    }


}