package com.application.sxm.korevie.network

import com.application.sxm.korevie.model.GankFuLiModel
import io.reactivex.Observable

/**
 * gank.io api工具类
 * Created by shixiaoming on 2019-07-16.
 */
class GankApiProvider {
    private val service: ApiService

    val fuli: Observable<GankFuLiModel>
        get() = service.getGankFuLi()

    init {
        service = RetrofitServiceManager.getInstance().create(ApiService::class.java)
    }

    companion object {

        private var instance: GankApiProvider? = null

        fun getInstance() = instance?: synchronized(this){
            instance?:GankApiProvider().also { instance = it }
        }
    }
}