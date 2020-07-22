package com.mtjin.firebasemvvm.data.source.local

import com.mtjin.firebasemvvm.data.Message
import io.reactivex.Completable
import io.reactivex.Single

interface MainLocalDataSource {
    fun insertMessage(message: Message) : Completable
    fun getMessages() : Single<List<Message>>
}