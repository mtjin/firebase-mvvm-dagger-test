package com.mtjin.firebasemvvm.data.source

import android.util.Log
import com.mtjin.firebasemvvm.data.Message
import com.mtjin.firebasemvvm.data.source.local.MainLocalDataSource
import com.mtjin.firebasemvvm.data.source.remote.MainRemoteDataSource
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainRemoteDataSource: MainRemoteDataSource,
    private val mainLocalDataSource: MainLocalDataSource
) :
    MainRepository {
    override fun getMessages(): Observable<Message> {
        return mainRemoteDataSource.getMessages().flatMap {
            Log.d("FFF", "MainRepo getMessages() -> $it")
            mainLocalDataSource.insertMessage(it).andThen(Observable.just(it))
        }
    }

    override fun getLocalMessages() = mainLocalDataSource.getMessages()

    override fun sendMessage(message: Message) {
        mainRemoteDataSource.sendMessage(message)
    }
}