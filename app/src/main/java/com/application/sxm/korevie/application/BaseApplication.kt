package com.application.sxm.korevie.application

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * application
 * Created by shixiaoming on 2019-07-16.
 */
class BaseApplication: Application(){

    override fun onCreate() {
        super.onCreate()
        initSDK()
    }
    companion object{
        lateinit var instance: BaseApplication
    }

    private fun initSDK(){
        Fresco.initialize(this)
    }
}