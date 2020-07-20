package com.mtjin.firebasemvvm.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mtjin.firebasemvvm.base.BaseViewModel
import com.mtjin.firebasemvvm.data.Message
import com.mtjin.firebasemvvm.data.source.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class MainViewModel @Inject constructor(private val mainRepository: MainRepository) :
    BaseViewModel() {
    private var currentQuery: String = ""


    val query = MutableLiveData<String>()
    private val _messageList = MutableLiveData<ArrayList<Message>>()

    val messageList: LiveData<ArrayList<Message>> get() = _messageList

    fun getMessages() {
        compositeDisposable.add(
            mainRepository.getMessages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("FFFFGetMEssage", it.toString())
                    val list : ArrayList<Message> = ArrayList()
                    list.add(it)
                    _messageList.value = list
                }, {
                    Log.d("Error", it.message.toString())
                })

        )
    }

    fun sendMessage() {
        val uniqueID: String = UUID.randomUUID().toString()
        currentQuery = query.value.toString().trim()
        if (currentQuery.isNotEmpty()) {
            mainRepository.sendMessage(Message(uniqueID, currentQuery))
        }
    }
}