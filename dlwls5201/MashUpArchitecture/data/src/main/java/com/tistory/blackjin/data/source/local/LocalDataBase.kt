package com.tistory.blackjin.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tistory.blackjin.data.source.local.model.RepoDB

@Database(
    entities = [RepoDB::class],
    version = 1,
    exportSchema = false
)
abstract class LocalDataBase : RoomDatabase() {

    abstract fun getRepoDao(): RepoDao
}