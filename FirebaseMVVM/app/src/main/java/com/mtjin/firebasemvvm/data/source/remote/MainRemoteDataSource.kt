package com.mtjin.firebasemvvm.data.source.remote

import com.mtjin.firebasemvvm.data.Message

interface MainRemoteDataSource {
    fun getMessages()
    fun sendMessage(message: Message)
}