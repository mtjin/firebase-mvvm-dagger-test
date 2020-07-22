package com.mtjin.firebasemvvm.di

import android.content.Context
import androidx.room.Room
import com.mtjin.firebasemvvm.data.source.local.MainLocalDataSource
import com.mtjin.firebasemvvm.data.source.local.MainLocalDataSourceImpl
import com.mtjin.firebasemvvm.data.source.local.MessageDao
import com.mtjin.firebasemvvm.data.source.local.MessageDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun provideMainLocalDataSource(movieDao: MessageDao): MainLocalDataSource {
        return MainLocalDataSourceImpl(movieDao)
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): MessageDatabase {
        return Room.databaseBuilder(
            context,
            MessageDatabase::class.java,
            "Message.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMessageDao(messageDatabase: MessageDatabase): MessageDao {
        return messageDatabase.messageDao()
    }


}