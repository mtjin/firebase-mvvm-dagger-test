package com.mtjin.firebasemvvm.data.source.remote

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mtjin.firebasemvvm.data.Message
import io.reactivex.Observable
import javax.inject.Inject

class MainRemoteDataSourceImpl @Inject constructor(private val database: FirebaseDatabase) :
    MainRemoteDataSource {
    override fun getMessages(): Observable<Message> {
        return Observable.create { emitter ->
            val messageValueListener = database.getReference("messages")
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(error: DatabaseError) {
                        emitter.onError(error.toException())
                    }

                    override fun onDataChange(snapshot: DataSnapshot) {
                        for (messageSnapshot in snapshot.children) {
                            messageSnapshot.getValue(Message::class.java)?.run {
                                emitter.onNext(this)
                            }
                        }
                    }
                })
        }
    }

    override fun sendMessage(message: Message) {
        database.getReference("messages").push().setValue(message)
    }
}