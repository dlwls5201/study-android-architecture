package com.tistory.blackjin.domain.repository

import com.tistory.blackjin.domain.entity.RepoEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface RepoRepository {

    fun searchRepos(repo: String): Single<List<RepoEntity>>

    fun getRepo(ownerLogin: String, repoName: String): Single<RepoEntity>

    fun getRecentRepos(): Flowable<List<RepoEntity>>

    fun insertRecentRepo(repoEntity: RepoEntity): Completable
}
