package com.mtjin.firebasemvvm.data.source.remote

import com.mtjin.firebasemvvm.data.Message
import io.reactivex.Observable
import io.reactivex.Single
import java.util.*

interface MainRemoteDataSource {
    fun getMessages() : Observable<Message>
    fun sendMessage(message: Message)
}