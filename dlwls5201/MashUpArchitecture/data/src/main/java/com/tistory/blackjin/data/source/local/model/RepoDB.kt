package com.tistory.blackjin.data.source.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repo")
data class RepoDB(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val ownerName: String,
    val repoName: String,
    val profileUrl: String,
    val description: String?,
    val language: String?
)
