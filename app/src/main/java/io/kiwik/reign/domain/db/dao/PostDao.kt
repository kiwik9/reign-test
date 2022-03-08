package io.kiwik.reign.domain.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.kiwik.reign.domain.entities.Post

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg value: Post)

    @Query("select * from m_post order by createdAt desc")
    fun getPost(): LiveData<List<Post>>

    @Query("delete from m_post where storyId = :id ")
    suspend fun removePost(id: Int)

}