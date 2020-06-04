package com.tistory.blackjin.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("name")
    val name: String?,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("following")
    val following: Int
)