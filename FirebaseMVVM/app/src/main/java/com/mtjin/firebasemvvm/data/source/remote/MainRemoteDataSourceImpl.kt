package com.mtjin.firebasemvvm.data.source.remote

import android.util.Log
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.mtjin.firebasemvvm.data.Message
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import javax.inject.Inject


class MainRemoteDataSourceImpl @Inject constructor(private val database: DatabaseReference) :
    MainRemoteDataSource {
    override fun requestMessages(): Flowable<Message> {
        return Flowable.create<Message>({ emitter ->
            val messageChildEventListener = object : ChildEventListener {
                override fun onCancelled(error: DatabaseError) {
                    Log.d("FFF", "Remote getMessages() onCancelled()  -> 에러")
                    emitter.onError(error.toException())
                }

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                    TODO("Not yet implemented")
                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                    snapshot.getValue(Message::class.java)?.run {
                        Log.d("FFF", this.toString())
                        emitter.onNext(this)
                    }
                }

                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                    snapshot.getValue(Message::class.java)?.run {
                        emitter.onNext(this)
                    }
                }

                override fun onChildRemoved(snapshot: DataSnapshot) {
                    TODO("Not yet implemented")
                }
            }
            database.child("messages").addChildEventListener(messageChildEventListener)
            emitter.setCancellable {
                Log.d("FFF" , "->캔슬됨")
                database.child("messages").removeEventListener(messageChildEventListener)
            }
        }, BackpressureStrategy.BUFFER)
    }

    override fun sendMessage(message: Message) {
        database.child("messages").push().setValue(message)
    }
}