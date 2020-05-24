package com.tistory.blackjin.data.mapper

import com.tistory.blackjin.data.model.Repo
import com.tistory.blackjin.domain.entity.RepoEntity

class RepoEntityMapper : EntityMapper<Repo, RepoEntity> {

    override fun mapFromRemote(model: Repo) = RepoEntity(
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