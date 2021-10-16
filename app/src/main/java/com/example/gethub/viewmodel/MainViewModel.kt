package com.example.gethub.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gethub.model.ResponseUserInfo
import com.example.gethub.model.RetrofitBuilder
import com.example.gethub.model.User
import com.example.gethub.model.UserInfo
import retrofit2.Call
import retrofit2.Response

class MainViewModel : ViewModel(){

    private var id = ""

    //값이 변경되는 경우 MutableLiveData 로 선언한다.
//    val _load = MutableLiveData<Int>()
//
//    val load : LiveData<Int> = _load

    // LiveData 는 값을 변경할 수 없고, 읽기만 가능하다.
    val getResponse : LiveData<ResponseUserInfo> get() = _response

    // MutableLiveData 는 값 변경 또한 가능하다
    private val _response = MutableLiveData<ResponseUserInfo>()

//    val TAG = "로그"

//    init {
//        _load.value = 0
//    }

//    fun setid (newid : String) {
//        id = newid
//    }
//
//    fun getId() = id

    fun setloadbutton () {
        // data class 는 값을 넣어주는 곳이 아니라 들어오는 값을 형태를 알려주는 것
        RetrofitBuilder.api.getUserInfo(userid = User.userid).enqueue(object : retrofit2.Callback<ResponseUserInfo> {

/*            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                val userinfo = response.body()
                Log.d("log","${userinfo?.following}")
                UserInfo.avatar_url = userinfo?.avatar_url
                UserInfo.company= userinfo?.company
                UserInfo.followers = userinfo?.followers
                UserInfo.following = userinfo?.following
                UserInfo.html_url = userinfo?.html_url
                UserInfo.name = userinfo!!.name
                UserInfo.userId = userinfo.name
                _response.value = userinfo
            }

            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                Log.d("error", t.message.toString())
            }*/

            override fun onResponse(
                call: Call<ResponseUserInfo>,
                response: Response<ResponseUserInfo>
            ) {
                val userinfo = response.body()
                Log.d("log","${userinfo?.following}, $userinfo")
                UserInfo.avatar_url = userinfo?.avatar_url
                UserInfo.company= userinfo?.company
                UserInfo.followers = userinfo?.followers
                UserInfo.following = userinfo?.following
                UserInfo.html_url = userinfo?.html_url
                UserInfo.name = userinfo!!.name
                UserInfo.userId = userinfo.userId
            }

            override fun onFailure(call: Call<ResponseUserInfo>, t: Throwable) {
                Log.d("error", t.message.toString())
            }
        })
    }


}