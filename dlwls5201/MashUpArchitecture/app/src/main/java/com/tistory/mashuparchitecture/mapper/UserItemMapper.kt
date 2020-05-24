package com.tistory.mashuparchitecture.mapper

import android.content.Context
import android.text.TextUtils
import com.tistory.blackjin.domain.entity.UserEntity
import com.tistory.mashuparchitecture.R
import com.tistory.mashuparchitecture.model.UserItem

class UserItemMapper(private val context: Context) : Mapper<UserItem, UserEntity> {

    override fun mapToView(entity: UserEntity) = UserItem(
        name = if (TextUtils.isEmpty(entity.name))
            context.resources.getString(R.string.unknown)
        else entity.name ?: "",
        profileUrl = entity.profileUrl,
        followers = if (entity.followers > 999)
            "999+"
        else
            entity.followers.toString()
        ,
        following = if (entity.following > 999)
            "999+"
        else
            entity.following.toString()
    )
}