package com.mtjin.firebasemvvm.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mtjin.firebasemvvm.base.BaseViewModel
import com.mtjin.firebasemvvm.data.Message
import com.mtjin.firebasemvvm.data.source.MainRepository
import com.mtjin.firebasemvvm.utils.NetworkManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkManager: NetworkManager
) :
    BaseViewModel() {
    private var currentQuery: String = ""
    private val receiveMessageList: ArrayList<Message> = ArrayList()

    val query = MutableLiveData<String>()
    private val _networkState = MutableLiveData<Unit>()
    private val _messageList = MutableLiveData<ArrayList<Message>>()

    val networkState: LiveData<Unit> get() = _networkState
    val messageList: LiveData<ArrayList<Message>> get() = _messageList

    fun getMessages() {
        Log.d("FFF", networkManager.checkNetworkState().toString())
        if (networkManager.checkNetworkState()) {
            compositeDisposable.add(
                mainRepository.requestMessages()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe {
                        Log.d("LLL", "시작시작")
                        showProgressDialog() }
                    .subscribe({
                        receiveMessageList.add(it)
                        _messageList.value = receiveMessageList
                        hideProgressDialog()
                    }, {
                        Log.d("Error", it.message.toString())
                    })
            )
        } else {
            _networkState.value = Unit
            compositeDisposable.add(
                mainRepository.requestLocalMessages()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { showProgressDialog() }
                    .doAfterTerminate { hideProgressDialog() }
                    .subscribe({
                        it?.run {
                            receiveMessageList.addAll(this)
                            _messageList.value = receiveMessageList
                        }
                    }, {
                        Log.d("Error", it.message.toString())
                    })
            )
        }
    }

    fun sendMessage() {
        if (networkManager.checkNetworkState()) {
            val uniqueID: String = UUID.randomUUID().toString()
            currentQuery = query.value.toString().trim()
            mainRepository.sendMessage(Message(uniqueID, currentQuery))
        } else {
            _networkState.value = Unit
        }
        query.value = ""
    }
}