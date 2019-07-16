package com.application.sxm.korevie.network

import com.application.sxm.korevie.model.MovieListModel
import io.reactivex.Observable

/**
 * 豆瓣接口提供类
 * Created by shixiaoming on 2019-07-15.
 */
class DoubanApiProvider{
    private val service: ApiService

    /**
     * 获取热门电影
     * @return
     */
    val hotMovie: Observable<MovieListModel>
        get() = service.getHotMovie()

    init {

        service = RetrofitServiceManager.getInstance().create(ApiService::class.java)
    }

    companion object {

        private var instance: DoubanApiProvider? = null

        fun getInstance() = instance?: synchronized(this){
            instance?:DoubanApiProvider().also { instance = it }
        }
    }
}