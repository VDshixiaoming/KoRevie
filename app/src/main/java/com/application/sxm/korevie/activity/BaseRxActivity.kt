package com.application.sxm.korevie.activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.application.sxm.korevie.R
import com.application.sxm.korevie.util.StatusBarUtil
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Rx绑定Activity生命周期
 * Created by shixiaoming on 2019-07-12.
 */
abstract class BaseRxActivity: RxAppCompatActivity() {
    protected lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        mContext = this
        initStatusBar()
        initView()
    }

    abstract fun getLayoutId(): Int

    open fun initView() {}

    private fun initStatusBar() = StatusBarUtil.setColorNoTranslucent(mContext as Activity, mContext.getColor(R.color.colorPrimary))

}