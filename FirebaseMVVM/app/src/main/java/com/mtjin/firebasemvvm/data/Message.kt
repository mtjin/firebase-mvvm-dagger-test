package com.mtjin.firebasemvvm.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

//테스트 프로젝트이기 때문에 프라이머리키를 그냥 콘텐트로 해놨음
@IgnoreExtraProperties
@Entity(tableName = "message")
data class Message(
    @SerializedName("title") var title: String = "",
    @PrimaryKey @SerializedName("content") var content: String = ""
)