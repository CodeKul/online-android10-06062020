package com.ani.online.storage.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ani.online.storage.R
import com.ani.online.storage.StorageApp
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)


        val chatRepo = ChatRepository((application as StorageApp).db.chatDao())

        val adapter = ChatAdapter(this, emptyList() )
        chatRc.adapter = adapter
        chatRc.layoutManager = LinearLayoutManager(this)

        val chatsData = (application as StorageApp).db.chatDao().chats()
        chatsData.observe(this, Observer {chats ->
            adapter.update(chats)
        })
        btOk.setOnClickListener {
            Thread {
                chatRepo.save(
                    Chat(
                        System.currentTimeMillis(),
                        "Ani",
                        etCht.text.toString()
                    )
                )
            }.start()
        }
    }
}