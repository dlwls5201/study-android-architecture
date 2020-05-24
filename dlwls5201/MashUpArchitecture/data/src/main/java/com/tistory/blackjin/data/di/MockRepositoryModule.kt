package com.tistory.blackjin.data.di

import com.tistory.blackjin.data.mapper.RepoEntityMapper
import com.tistory.blackjin.data.mapper.UserEntityMapper
import com.tistory.blackjin.data.mockrepositoryImpl.MpckRepoRepositoryImpl
import com.tistory.blackjin.data.repositoryimpl.UserRepositoryImpl
import com.tistory.blackjin.data.source.remote.RepoApi
import com.tistory.blackjin.data.source.remote.UserApi
import com.tistory.blackjin.domain.repository.RepoRepository
import com.tistory.blackjin.domain.repository.UserRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val mockRepositoryModule = module {

    // mock repository
    single<RepoRepository> {
        MpckRepoRepositoryImpl()
    }

    single<UserRepository> {
        UserRepositoryImpl(get(), get())
    }

    // local

    // remote
    single { get<Retrofit>().create(RepoApi::class.java) }
    single { get<Retrofit>().create(UserApi::class.java) }

    single { RepoEntityMapper() }
    single { UserEntityMapper() }
}