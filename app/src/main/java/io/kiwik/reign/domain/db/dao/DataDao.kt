package io.kiwik.reign.domain.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.kiwik.reign.domain.entities.Data

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg value: Data)

    @Query("Select * from m_data")
    suspend fun getData(): List<Data>

}
