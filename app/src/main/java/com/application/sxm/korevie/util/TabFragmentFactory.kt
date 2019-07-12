package com.application.sxm.korevie.util

import com.application.sxm.korevie.fragment.HomeFragment
import com.application.sxm.korevie.fragment.MineFragment
import com.application.sxm.korevie.fragment.TicketFragment
import com.application.sxm.korevie.fragment.VideoFragment

/**
 * 首页fragment工场类
 * Created by shixiaoming on 2019-07-12.
 */
class TabFragmentFactory private constructor(){

    private var homeFragment: HomeFragment? = null
    private var videoFragment: VideoFragment? = null
    private var ticketFragment: TicketFragment? = null
    private var mineFragment: MineFragment? = null

    /**
     * synchronize锁单例
     */
    companion object {
        val mInstance: TabFragmentFactory by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            TabFragmentFactory()
        }
    }

    fun getHomeFragment() : HomeFragment? {
        if (homeFragment == null) {
            homeFragment = HomeFragment()
        }
        return homeFragment
    }

    fun getTicketFragment() : TicketFragment? {
        if (ticketFragment == null) {
            ticketFragment = TicketFragment()
        }
        return ticketFragment
    }

    fun getVideoFragment() : VideoFragment? {
        if (videoFragment == null) {
            videoFragment = VideoFragment()
        }
        return videoFragment
    }

    fun getMineFragment() : MineFragment?{
        if (mineFragment == null) {
            mineFragment = MineFragment()
        }
        return mineFragment
    }
}