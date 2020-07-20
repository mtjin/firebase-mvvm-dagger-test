package com.mtjin.firebasemvvm.data.source.remote

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.mtjin.firebasemvvm.data.Message
import javax.inject.Inject

class MainRemoteDataSourceImpl @Inject constructor(private val database: DatabaseReference) :
    MainRemoteDataSource {
    override fun getMessages() {
        Firebase.database.getReference("messages")
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    TODO("Not yet implemented")
                }

            })

    }

    override fun sendMessage(message: Message) {
        database.child("messages").push()
    }
}