package com.application.sxm.korevie.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * http拦截器，添加公共参数
 * Created by shixiaoming on 2019-07-11.
 */
class HttpBaseInterceptor : Interceptor {

    private var baseParams = hashMapOf<String?, String?>()

    override fun intercept(chain: Interceptor.Chain): Response {
        val originRequest = chain.request()
        val requestBuilder = originRequest.newBuilder()
        requestBuilder.method(originRequest.method(), originRequest.body())

        //添加公共参数到请求头
        if (baseParams.size > 0) {
            for ((key, value) in baseParams) {
                requestBuilder.header(key, value)
            }
        }
        val newRequest = requestBuilder.build()

        return chain.proceed(newRequest)
    }

    class Builder {
        internal var mInterceptor: HttpBaseInterceptor

        init {
            mInterceptor = HttpBaseInterceptor()
        }

        fun addHeaderParam(key: String, value: String): Builder {
            mInterceptor.baseParams[key] = value
            return this
        }

        fun addHeaderParams(params: Map<String, String>): Builder {
            mInterceptor.baseParams.putAll(params)
            return this
        }

        fun build(): HttpBaseInterceptor {
            return mInterceptor
        }
    }
}