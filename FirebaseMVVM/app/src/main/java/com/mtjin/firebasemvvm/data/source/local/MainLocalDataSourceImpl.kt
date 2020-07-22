package com.mtjin.firebasemvvm.data.source.local

import com.mtjin.firebasemvvm.data.Message
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MainLocalDataSourceImpl @Inject constructor(private val messageDao: MessageDao) :
    MainLocalDataSource {
    override fun insertMessage(message: Message): Completable {
        return messageDao.insertMessage(message)
    }

    override fun getMessages(): Single<List<Message>> {
        return messageDao.getMessages()
    }


}