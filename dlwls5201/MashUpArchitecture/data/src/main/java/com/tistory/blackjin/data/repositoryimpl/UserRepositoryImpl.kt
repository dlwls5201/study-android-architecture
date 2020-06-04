package com.tistory.blackjin.data.repositoryimpl

import com.tistory.blackjin.data.composeDomain
import com.tistory.blackjin.data.source.remote.UserApi
import com.tistory.blackjin.data.source.remote.mapper.UserEntityMapper
import com.tistory.blackjin.domain.entity.UserEntity
import com.tistory.blackjin.domain.repository.UserRepository
import io.reactivex.Single

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val userEntityMapper: UserEntityMapper
) : UserRepository {

    override fun getUser(username: String): Single<UserEntity> {
        return userApi.getUser(username)
            .map { userEntityMapper.mapFromRemote(it) }
            .composeDomain()
    }
}