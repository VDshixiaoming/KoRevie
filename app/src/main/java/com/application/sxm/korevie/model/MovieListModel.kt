package com.application.sxm.korevie.model

/**
 * 热映电影model
 * Created by shixiaoming on 2019-07-11.
 */
data class MovieListModel(
    val count: Int, val start: Int, val total: Int,
    val title: String, val subjects: List<MovieItemBean>
)