package com.tistory.blackjin.data.source.remote.mapper

import com.tistory.blackjin.data.source.remote.model.UserModel
import com.tistory.blackjin.domain.entity.UserEntity

class UserEntityMapper : EntityMapper<UserModel, UserEntity> {

    override fun mapFromRemote(model: UserModel) = UserEntity(
        name = model.name,
        profileUrl = model.avatarUrl,
        followers = model.followers,
        following = model.following
    )
}