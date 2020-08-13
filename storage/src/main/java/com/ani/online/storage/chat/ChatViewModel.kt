package com.ani.online.storage.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ChatViewModel(
    private val repo : ChatRepository
) : ViewModel() {

    val chats : LiveData<List<Chat>> = repo.chats
}