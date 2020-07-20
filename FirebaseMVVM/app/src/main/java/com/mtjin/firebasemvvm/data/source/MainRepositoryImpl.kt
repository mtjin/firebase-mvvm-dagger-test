package com.mtjin.firebasemvvm.data.source

import com.mtjin.firebasemvvm.data.Message
import com.mtjin.firebasemvvm.data.source.remote.MainRemoteDataSource
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val mainRemoteDataSource: MainRemoteDataSource) :
    MainRepository {
    override fun getMessages() {
        TODO("Not yet implemented")
    }

    override fun sendMessage(message: Message) {
        TODO("Not yet implemented")
    }
}