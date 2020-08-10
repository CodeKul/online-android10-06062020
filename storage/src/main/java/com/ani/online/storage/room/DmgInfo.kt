package com.ani.online.storage.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dmg_info")
class DmgInfo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id")
    val id : Long,
    val nm : String,
    val age : Int,
    val mobile : String
)