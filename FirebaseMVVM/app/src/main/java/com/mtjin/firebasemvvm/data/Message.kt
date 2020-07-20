package com.mtjin.firebasemvvm.data

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Message(val title: String, val message: String)