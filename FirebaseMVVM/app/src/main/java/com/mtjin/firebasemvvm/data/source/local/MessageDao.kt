package com.mtjin.firebasemvvm.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mtjin.firebasemvvm.data.Message
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MessageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMessage(message: Message): Completable

    @Query("SELECT * FROM message")
    fun getMessages(): Single<List<Message>>
}