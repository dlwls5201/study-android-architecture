package com.tistory.blackjin.data.repositoryimpl

import com.tistory.blackjin.data.composeDomain
import com.tistory.blackjin.data.source.local.RepoDao
import com.tistory.blackjin.data.source.local.mapper.RepoDBMapper
import com.tistory.blackjin.data.source.remote.RepoApi
import com.tistory.blackjin.data.source.remote.mapper.RepoEntityMapper
import com.tistory.blackjin.domain.entity.RepoEntity
import com.tistory.blackjin.domain.repository.RepoRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class RepoRepositoryImpl(
    private val repoApi: RepoApi,
    private val repoDao: RepoDao,
    private val repoEntityMapper: RepoEntityMapper,
    private val repoDBMapper: RepoDBMapper
) : RepoRepository {

    override fun searchRepos(repo: String): Single<List<RepoEntity>> {
        return repoApi.searchRepository(repo)
            .map {
                it.items.map {
                    repoEntityMapper.mapFromRemote(it)
                }
            }.composeDomain()
    }

    override fun getRepo(ownerLogin: String, repoName: String): Single<RepoEntity> {
        return repoApi.getRepository(ownerLogin, repoName)
            .map { repoEntityMapper.mapFromRemote(it) }
            .composeDomain()
    }

    override fun getRecentRepos(): Flowable<List<RepoEntity>> {
        return repoDao.getRepos()
            .map { it.map { repoDBMapper.mapFromLocal(it) } }
    }

    override fun insertRecentRepo(repoEntity: RepoEntity): Completable {
        return Completable.fromCallable {
            repoDao.insert(repoDBMapper.mapToLocal(repoEntity))
        }
    }
}