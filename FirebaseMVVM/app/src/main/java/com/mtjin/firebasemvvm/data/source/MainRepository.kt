package com.mtjin.firebasemvvm.data.source

import com.mtjin.firebasemvvm.data.Message
import io.reactivex.Observable

interface MainRepository {
    fun getMessages(): Observable<Message>
    fun sendMessage(message: Message)
}