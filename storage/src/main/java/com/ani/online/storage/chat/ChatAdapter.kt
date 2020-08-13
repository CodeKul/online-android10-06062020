package com.ani.online.storage.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ani.online.storage.R

class ChatAdapter(
    private val ctx : Context,
    private var chats : List<Chat>
) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {

        val msg = view.findViewById<TextView>(R.id.txtMsg)
        val frm = view.findViewById<TextView>(R.id.txtFrm)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val inf = LayoutInflater.from(ctx)
        return ChatViewHolder(inf.inflate(R.layout.chat_item, parent, false))
    }

    override fun getItemCount(): Int = chats.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.frm.text = chats[position].from
        holder.msg.text = chats[position].msg
    }

    fun update( chats : List<Chat> ) {
        this.chats = chats
        notifyDataSetChanged()
    }
}