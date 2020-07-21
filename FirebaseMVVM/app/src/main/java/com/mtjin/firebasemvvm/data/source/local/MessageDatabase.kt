package com.mtjin.firebasemvvm.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mtjin.firebasemvvm.data.Message

@Database(entities = [Message::class], version = 1, exportSchema = false)
abstract class MessageDatabase : RoomDatabase(){
    abstract fun messageDao() : MessageDao
}