package com.ani.online.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ani.online.storage.chat.Chat
import com.ani.online.storage.chat.ChatDao
import com.ani.online.storage.room.DmgDao
import com.ani.online.storage.room.DmgInfo

@Database(entities = [DmgInfo::class, Chat::class], version = 1, exportSchema = false)
abstract class AppDb : RoomDatabase(){

    abstract fun dmgInfoDao() : DmgDao

    abstract fun chatDao() : ChatDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDb? = null

        fun getDatabase(context: Context): AppDb {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDb::class.java,
                    "demographic_info_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}