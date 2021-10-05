package com.example.gethub.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gethub.model.User
import com.example.gethub.databinding.ActivityMainBinding
import com.example.gethub.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {



    private lateinit var mBinding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)



        mBinding.submitBtn.setOnClickListener {

            val user = mBinding.inputUserEt.text.toString().trim()

            User.userid = user


            startActivity(Intent(this, SplashActivity::class.java))
            overridePendingTransition(0, 0)

            MainViewModel().setloadbutton()
            finish()


        }
    }
}