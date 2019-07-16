package com.application.sxm.korevie.network

import com.application.sxm.korevie.util.AppConstants
import com.application.sxm.korevie.util.UserInfoUtil
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.HashMap
import java.util.concurrent.TimeUnit

/**
 * 网络配置
 * 创建OkHttpClient，设置拦截参数
 * Created by shixiaoming on 2019-07-11.
 */
class RetrofitServiceManager {

    companion object {
        private val CONNECT_TIME_OUT: Long = 5 //链接超时
        private val IO_TIME_OUT: Long = 10 //读写超时
        private val instance = SingletonHolder.INSTANCE

        fun getInstance(): RetrofitServiceManager {
            return SingletonHolder.INSTANCE
        }
    }

    private object SingletonHolder {
        val INSTANCE = RetrofitServiceManager()
    }

    lateinit var mRetrofit: Retrofit

    fun isRetrofitInitialzed()= ::mRetrofit.isInitialized

    /**
     * 获取Service
     */
    fun <T> create(service: Class<T>): T {
        if (!isRetrofitInitialzed()) {
            createOkHttpClient()
        }
        return mRetrofit.create(service)
    }

    /**
     * 创建OKHttpClient
     */
    fun createOkHttpClient() {
        val builder = OkHttpClient.Builder()

        //设置超时时间
        builder.connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
        builder.writeTimeout(IO_TIME_OUT, TimeUnit.SECONDS)
        builder.readTimeout(IO_TIME_OUT, TimeUnit.SECONDS)
        builder.retryOnConnectionFailure(true)

        //设置拦截器参数
        val baseInterceptor = HttpBaseInterceptor.Builder().addHeaderParams(getBaseParams()).build()
        builder.addInterceptor(baseInterceptor)

        //创建Retrofit
        mRetrofit = Retrofit.Builder().client(builder.build()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl(AppConstants.GANK_IO_BASE).build()

    }

    /**
     * 公共参数
     * @return
     */
    private fun getBaseParams(): Map<String, String> {
        val params = HashMap<String, String>()
        params["platform"] = "android"
        params["deviceId"] = UserInfoUtil.getDeviceId()

        return params
    }
}