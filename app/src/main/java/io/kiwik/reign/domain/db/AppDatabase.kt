package io.kiwik.reign.domain.db

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.kiwik.reign.MvpApp
import io.kiwik.reign.domain.db.dao.DataDao
import io.kiwik.reign.domain.entities.Data
import io.kiwik.reign.utilities.DB_NAME


@Database(
    entities = [Data::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    private val mIsDatabaseCreated = MutableLiveData<Boolean>()

    abstract fun dataDao(): DataDao

    private fun setDatabaseCreated() {
        mIsDatabaseCreated.postValue(true)
    }

    companion object {

        private var instance: AppDatabase? = null

        fun getInstance(): AppDatabase {
            val context = MvpApp.instance.applicationContext
            return instance ?: synchronized(this) {
                instance ?: buildDatabaseDev(context).also { instance = it }
            }
        }

        fun buildDatabaseDev(appContext: Context): AppDatabase {
            val database = Room.databaseBuilder(appContext, AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration().build()
            database.setDatabaseCreated()
            return database
        }
    }

}
