package com.application.sxm.korevie.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * 禁止滑动ViewPager
 * Created by shixiaoming on 2019-07-12.
 */
class ForbidSlidViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        //不处理事件
        return false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        //不拦截事件，向下透传
        return false
    }
}
