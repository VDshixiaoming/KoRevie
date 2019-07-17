package com.application.sxm.korevie.network

import com.application.sxm.korevie.model.GankFuLiModel
import com.application.sxm.korevie.model.GankSearchModel
import com.application.sxm.korevie.model.MovieListModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 接口服务
 * Created by shixiaoming on 2019-07-11.
 */
interface ApiService {

    /**
     * 豆瓣Top250电影榜单，已挂
     */
    @GET("top250")
    fun getTopMovies(@Query("start") start: Int, @Query("count") count: Int) : Observable<MovieListModel>

    /**
     * 豆瓣热映电影
     */
    @GET("v2/movie/in_theaters")
    fun getHotMovie(): Observable<MovieListModel>

    /**
     * gank.io接口
     */
    @GET("福利/10/1")
    fun getGankFuLi(): Observable<GankFuLiModel>

    /**
     * gank.io搜索接口
     * @param query 查询内容
     * @param category 查询类别 all | Android | ios | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐
     */
    @GET("search/query/{query}/category/{category}/count/{count}/page/{page}")
    fun getSearchResult(@Path("query") query: String,@Path("category") category: String,
         @Path("count") count: Int, @Path("page") page: Int): Observable<GankSearchModel>

}