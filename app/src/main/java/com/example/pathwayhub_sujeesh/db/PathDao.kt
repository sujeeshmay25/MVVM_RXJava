/*
package com.example.pathwayhub_sujeesh.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pathwayhub_sujeesh.network.PathPojo

@Dao
interface PathDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun storePath(task: ArrayList<PathPojo.Response.Doc>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun storePath(task: PathPojo.Response.Doc)


    @Query("SELECT id,publication_date,article_type,abstract FROM doc ")
    fun getValue(): ArrayList<PathPojo.Response.Doc>
}*/
