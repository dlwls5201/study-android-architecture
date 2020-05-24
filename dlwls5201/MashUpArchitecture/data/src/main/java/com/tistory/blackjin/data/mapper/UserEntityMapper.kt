package com.tistory.blackjin.data.mapper

import com.tistory.blackjin.data.model.User
import com.tistory.blackjin.domain.entity.UserEntity

class UserEntityMapper : EntityMapper<User, UserEntity> {

    override fun mapFromRemote(model: User) = UserEntity(
        name = model.name,
        profileUrl = model.avatarUrl,
        followers = model.followers,
        following = model.following
    )
}