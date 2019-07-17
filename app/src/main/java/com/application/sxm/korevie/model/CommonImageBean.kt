package com.application.sxm.korevie.model

import java.io.Serializable

/**
 * 通用图片model
 * 大、中、小图
 * Created by shixiaoming on 2019-07-15.
 */
data class CommonImageBean(
    val small: String,
    val large: String,
    val medium: String
): Serializable