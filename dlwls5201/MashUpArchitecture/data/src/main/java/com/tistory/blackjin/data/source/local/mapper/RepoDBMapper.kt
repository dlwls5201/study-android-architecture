package com.tistory.blackjin.data.source.local.mapper

import com.tistory.blackjin.data.source.local.model.RepoDB
import com.tistory.blackjin.domain.entity.RepoEntity
import java.util.*

class RepoDBMapper : DBMapper<RepoDB, RepoEntity> {

    override fun mapFromLocal(model: RepoDB) = RepoEntity(
        repoName = model.repoName,
        owner = RepoEntity.OwnerEntity(
            ownerName = model.repoName,
            ownerUrl = model.profileUrl
        ),
        description = model.description,
        language = model.language,
        updatedAt = Date(),
        stars = 0
    )

    override fun mapToLocal(entity: RepoEntity) = RepoDB(
        ownerName = entity.owner.ownerName,
        repoName = entity.repoName,
        profileUrl = entity.owner.ownerUrl,
        description = entity.description,
        language = entity.language
    )
}
