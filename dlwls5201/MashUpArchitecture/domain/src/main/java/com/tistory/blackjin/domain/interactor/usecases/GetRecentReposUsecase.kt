package com.tistory.blackjin.domain.interactor.usecases

import com.tistory.blackjin.domain.entity.RepoEntity
import com.tistory.blackjin.domain.repository.RepoRepository
import com.tistory.blackjin.domain.schedulers.SchedulersProvider
import io.reactivex.Flowable

class GetRecentReposUsecase(
    private val repoRepository: RepoRepository,
    private val schedulersProvider: SchedulersProvider
) {

    fun get(): Flowable<List<RepoEntity>> {
        return repoRepository.getRecentRepos()
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())
    }
}