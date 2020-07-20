package com.mtjin.firebasemvvm.data.source

import com.mtjin.firebasemvvm.data.Message

interface MainRepository {
    fun getMessages()
    fun sendMessage(message: Message)
}