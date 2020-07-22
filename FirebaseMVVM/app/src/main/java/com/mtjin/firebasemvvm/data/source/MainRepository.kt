package com.mtjin.firebasemvvm.data.source

import com.mtjin.firebasemvvm.data.Message
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

interface MainRepository {
    fun requestMessages(): Flowable<Message>
    fun sendMessage(message: Message)
    fun requestLocalMessages(): Single<List<Message>>
    fun saveLocalMessage(message : Message)
}