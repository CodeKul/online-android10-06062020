package com.ani.online.storage.chat

import androidx.lifecycle.LiveData

class ChatRepository(
    private val dao : ChatDao
) {
    val chats : LiveData<List<Chat>> = dao.chats()

    fun save(chat : Chat) {
        dao.save(chat)
    }
}