package com.tistory.blackjin.data.source.remote.mapper

import com.tistory.blackjin.data.source.remote.model.RepoModel
import com.tistory.blackjin.domain.entity.RepoEntity

class RepoEntityMapper : EntityMapper<RepoModel, RepoEntity> {

    override fun mapFromRemote(model: RepoModel) = RepoEntity(
        repoName = model.name,
        owner = RepoEntity.OwnerEntity(
            ownerName = model.owner.login,
            ownerUrl = model.owner.avatarUrl
        ),
        language = model.language,
        description = model.description,
        updatedAt = model.updatedAt,
        stars = model.stars
    )
}