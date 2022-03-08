package io.kiwik.reign.repository

import io.kiwik.reign.domain.db.AppDatabase
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseRepository : KoinComponent {
    val db: AppDatabase by inject()
    internal val dataDao by lazy { db.dataDao() }

}

val REPOSITORY_LIST by lazy {
    arrayOf(
        DataRepository()
    )
}