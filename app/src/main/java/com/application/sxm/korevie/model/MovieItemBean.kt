package com.application.sxm.korevie.model

import java.io.Serializable

/**
 * 电影实体mdoel
 * Created by shixiaoming on 2019-07-15.
 */
data class MovieItemBean(
    val rating: RatingBean,
    val title: String,
    val collect_count: Int,
    val original_title: String,
    val subtype: String,
    val year: String,
    val images: CommonImageBean,
    val alt: String,
    val id: String,
    val genres: List<String>,
    val casts: List<MovieCastsBean>,
    val directors: List<MovieCastsBean>
) : Serializable {
    data class RatingBean(
        val max: Int,
        val average: Double,
        val stars: String,
        val min: Int
    ): Serializable
}