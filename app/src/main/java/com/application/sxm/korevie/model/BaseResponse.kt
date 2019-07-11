package com.application.sxm.korevie.model

/**
 * 回调基类
 * Created by shixiaoming on 2019-07-11.
 */
open class BaseResponse<T> (val status: Int, val message: String, val data: T) {

    fun isSuccess(): Boolean {
        return status == 200
    }
}