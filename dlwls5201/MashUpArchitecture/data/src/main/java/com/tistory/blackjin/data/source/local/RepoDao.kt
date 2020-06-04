package com.tistory.blackjin.data.source.local

import androidx.room.*
import com.tistory.blackjin.data.source.local.model.RepoDB
import io.reactivex.Flowable

@Dao
interface RepoDao {

    @Query("SELECT * FROM repo")
    fun getRepos(): Flowable<List<RepoDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repo: RepoDB)

    @Update
    fun update(repo: RepoDB)

    @Delete
    fun delete(repo: RepoDB)

    @Query("DELETE FROM repo")
    fun clear()
}