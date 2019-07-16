package com.application.sxm.korevie.model

/**
 * Gank.io fuli api
 * Created by shixiaoming on 2019-07-16.
 */
data class GankFuLiModel(
        val error: Boolean,
        val results: List<FuLiItem>
)
{
    data class FuLiItem(
        val url: String,
        val who: String,
        val desc: String,
        val publishedAt: String
    )
}