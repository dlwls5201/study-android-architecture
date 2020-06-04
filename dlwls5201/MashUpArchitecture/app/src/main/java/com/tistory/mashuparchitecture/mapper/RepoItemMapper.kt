package com.tistory.mashuparchitecture.mapper

import android.content.Context
import android.text.TextUtils
import com.tistory.blackjin.domain.entity.RepoEntity
import com.tistory.mashuparchitecture.R
import com.tistory.mashuparchitecture.model.RepoItem
import java.text.SimpleDateFormat
import java.util.*

class RepoItemMapper(private val context: Context) : Mapper<RepoItem, RepoEntity> {

    private val dateFormatToShow = SimpleDateFormat(
        "yyyy-MM-dd HH:mm:ss", Locale.getDefault()
    )

    override fun mapToView(entity: RepoEntity) = RepoItem(
        title = entity.owner.ownerName + "/" + entity.repoName,
        repoName = entity.repoName,
        owner = RepoItem.OwnerItem(
            ownerName = entity.owner.ownerName,
            ownerUrl = entity.owner.ownerUrl
        ),

        description = if (TextUtils.isEmpty(entity.description))
            context.resources.getString(R.string.no_description_provided)
        else
            entity.description,

        language = if (TextUtils.isEmpty(entity.language))
            context.resources.getString(R.string.no_language_specified)
        else
            entity.language,

        updatedAt = try {
            dateFormatToShow.format(entity.updatedAt)
        } catch (e: IllegalArgumentException) {
            context.resources.getString(R.string.unknown)
        },

        stars = context.resources.getQuantityString(R.plurals.star, entity.stars, entity.stars)
    )


    override fun mapFromView(item: RepoItem) = RepoEntity(
        repoName = item.repoName,
        owner = RepoEntity.OwnerEntity(
            ownerName = item.owner.ownerName,
            ownerUrl = item.owner.ownerUrl
        ),
        description = item.description,
        language = item.language,
        updatedAt = Date(),
        stars = 0
    )
}