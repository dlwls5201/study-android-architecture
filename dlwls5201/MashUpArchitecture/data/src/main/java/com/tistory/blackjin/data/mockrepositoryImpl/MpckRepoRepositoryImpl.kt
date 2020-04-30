package com.tistory.blackjin.data.mockrepositoryImpl

import com.tistory.blackjin.domain.entity.RepoEntity
import com.tistory.blackjin.domain.repository.RepoRepository
import io.reactivex.Single
import java.util.*
import java.util.concurrent.TimeUnit

class MpckRepoRepositoryImpl : RepoRepository {

    override fun searchRepos(repo: String): Single<List<RepoEntity>> {
        return Single.just(
            listOf(
                RepoEntity(
                    "MashupArchitecture1",
                    RepoEntity.OwnerEntity("blackJin", ""),
                    "welcome house",
                    "kotlin",
                    Date(), 100
                ),
                RepoEntity(
                    "MashupArchitecture2",
                    RepoEntity.OwnerEntity("blackJin", ""),
                    "welcome house",
                    "java",
                    Date(), 1000
                )
            )
        ).delay(1000, TimeUnit.MILLISECONDS)
    }

    override fun getRepo(ownerLogin: String, repoName: String): Single<RepoEntity> {
        return Single.just(
            RepoEntity(
                "MashupArchitecture1",
                RepoEntity.OwnerEntity("blackJin", ""),
                "welcome house",
                "kotlin",
                Date(), 100
            )
        )
    }
}