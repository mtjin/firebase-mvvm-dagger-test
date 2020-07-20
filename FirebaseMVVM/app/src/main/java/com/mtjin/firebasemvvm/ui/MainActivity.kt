package com.mtjin.firebasemvvm.ui

import android.os.Bundle
import com.mtjin.firebasemvvm.R
import com.mtjin.firebasemvvm.base.BaseActivity
import com.mtjin.firebasemvvm.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
