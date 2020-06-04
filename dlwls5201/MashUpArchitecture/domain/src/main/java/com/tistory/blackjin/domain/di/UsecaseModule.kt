package com.tistory.blackjin.domain.di

import com.tistory.blackjin.domain.interactor.usecases.GetRecentReposUsecase
import com.tistory.blackjin.domain.interactor.usecases.GetRepoUsecase
import com.tistory.blackjin.domain.interactor.usecases.GetReposUsecase
import com.tistory.blackjin.domain.interactor.usecases.InsertRecentRepoUsecase
import org.koin.dsl.module

val usecaseModule = module {

    factory {
        GetReposUsecase(get(), get())
    }

    factory {
        GetRepoUsecase(get(), get(), get())
    }

    factory {
        GetRecentReposUsecase(get(), get())
    }

    factory {
        InsertRecentRepoUsecase(get(), get())
    }
}