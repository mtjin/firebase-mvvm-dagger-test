package com.mtjin.firebasemvvm.data

import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
data class Message(var title: String ="", var content: String="")