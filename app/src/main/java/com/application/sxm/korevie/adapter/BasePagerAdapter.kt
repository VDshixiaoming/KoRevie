package com.application.sxm.korevie.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * 首页viewpager adapter
 * Created by shixiaoming on 2019-07-12.
 */
class BasePagerAdapter(val manager: FragmentManager, val mFragmentList: List<*>, val mTitleList: List<String>): FragmentPagerAdapter(manager) {

    override fun getItem(p0: Int): Fragment {
        return mFragmentList.get(p0) as Fragment
    }

    override fun getCount(): Int {
        return if (mFragmentList.isEmpty()) 0 else mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (mTitleList.isEmpty()) "" else mTitleList.get(position)
    }
}