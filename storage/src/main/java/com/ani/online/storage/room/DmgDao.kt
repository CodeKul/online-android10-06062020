package com.ani.online.storage.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DmgDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveDmg(dmg : DmgInfo)

    @Query("select * from dmg_info")
    fun all() : List<DmgInfo>
}