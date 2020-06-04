package com.tistory.blackjin.domain.interactor.usecases

import com.tistory.blackjin.domain.entity.RepoEntity
import com.tistory.blackjin.domain.repository.RepoRepository
import com.tistory.blackjin.domain.schedulers.SchedulersProvider
import io.reactivex.Completable

class InsertRecentRepoUsecase(
    private val repoRepository: RepoRepository,
    private val schedulersProvider: SchedulersProvider
) {

    fun insert(repoEntity: RepoEntity): Completable {
        return repoRepository.insertRecentRepo(repoEntity)
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())
    }
}