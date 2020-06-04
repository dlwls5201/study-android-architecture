package com.tistory.blackjin.data.di

import androidx.room.Room
import com.tistory.blackjin.data.repositoryimpl.RepoRepositoryImpl
import com.tistory.blackjin.data.repositoryimpl.UserRepositoryImpl
import com.tistory.blackjin.data.source.local.LocalDataBase
import com.tistory.blackjin.data.source.local.mapper.RepoDBMapper
import com.tistory.blackjin.data.source.remote.RepoApi
import com.tistory.blackjin.data.source.remote.UserApi
import com.tistory.blackjin.data.source.remote.mapper.RepoEntityMapper
import com.tistory.blackjin.data.source.remote.mapper.UserEntityMapper
import com.tistory.blackjin.domain.repository.RepoRepository
import com.tistory.blackjin.domain.repository.UserRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoryModule = module {

    // repository
    single<RepoRepository> {
        RepoRepositoryImpl(get(), get(), get(), get())
    }

    single<UserRepository> {
        UserRepositoryImpl(get(), get())
    }

    // local
    single {
        get<LocalDataBase>().getRepoDao()
    }

    single {
        Room.databaseBuilder(
            androidApplication(),
            LocalDataBase::class.java,
            "repo.db"
        ).fallbackToDestructiveMigration()  //테스트용 : 빌드 시 마다 기존 데이터베이스 삭제
            .build()
    }

    single { RepoDBMapper() }

    // remote
    single { get<Retrofit>().create(RepoApi::class.java) }
    single { get<Retrofit>().create(UserApi::class.java) }

    single { RepoEntityMapper() }
    single { UserEntityMapper() }
}