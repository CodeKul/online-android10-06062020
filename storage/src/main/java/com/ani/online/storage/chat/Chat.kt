package com.ani.online.storage.chat

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chat_data")
data class Chat(
    @PrimaryKey
    val id : Long,
    val from : String,
    val msg : String
)