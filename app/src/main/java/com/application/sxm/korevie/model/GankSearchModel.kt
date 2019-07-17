package com.application.sxm.korevie.model




/**
 * gank.io接口返回
 * Created by shixiaoming on 2019-07-17.
 */
data class GankSearchModel(
    val count: Int, val error: Boolean,
    val rsults: List<GankSearchBean>
) {
    data class GankSearchBean(
        val title: String
    )
}