package com.mtjin.firebasemvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mtjin.firebasemvvm.R
import com.mtjin.firebasemvvm.base.BaseActivity
import com.mtjin.firebasemvvm.databinding.ActivityMainBinding
import com.mtjin.firebasemvvm.di.MyApplication
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var messageAdapter: MessageAdapter

    //대거
    lateinit var mainComponent: MainComponent
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        //대거
        mainComponent =
            (application as MyApplication).appComponent.mainComponent().create()
        mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        //대거
        mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        binding.vm = mainViewModel
        initAdapter()
        initViewModelCallback()
    }

    private fun initViewModelCallback() {
        with(mainViewModel) {
            networkState.observe(this@MainActivity, Observer {
                showToast("네트워크가 끊켜 있습니다. 로컬에서 불러옵니다")
            })

            isDialogLoading.observe(this@MainActivity, Observer { loadingState ->
                Log.d("LLL -> ",""+ loadingState)
                when (loadingState) {
                    true -> showProgressDialog()
                    false -> hideProgressDialog()
                }
            })
        }
    }

    private fun initAdapter() {
        messageAdapter = MessageAdapter()
        binding.rvItems.adapter = messageAdapter
        mainViewModel.getMessages()
    }
}
