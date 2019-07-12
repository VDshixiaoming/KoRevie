package com.application.sxm.korevie.activity

import android.support.design.widget.BottomNavigationView
import com.application.sxm.korevie.R
import com.application.sxm.korevie.adapter.BasePagerAdapter
import com.application.sxm.korevie.fragment.BaseFragment
import com.application.sxm.korevie.util.BottomNavigationHelper
import com.application.sxm.korevie.util.TabFragmentFactory
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : BaseRxActivity() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        super.initView()
        BottomNavigationHelper.disableShiftMode(navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        initViewPager()
    }

    fun initViewPager() {
        val fragments = ArrayList<BaseFragment>()
        fragments.add(TabFragmentFactory.mInstance.getHomeFragment() as BaseFragment)
        fragments.add(TabFragmentFactory.mInstance.getVideoFragment() as BaseFragment)
        fragments.add(TabFragmentFactory.mInstance.getTicketFragment() as BaseFragment)
        fragments.add(TabFragmentFactory.mInstance.getMineFragment() as BaseFragment)

        val titleList = ArrayList<String>()
        titleList.add(getString(R.string.title_home))
        titleList.add(getString(R.string.title_video))
        titleList.add(getString(R.string.title_ticket))
        titleList.add(getString(R.string.title_my))

        val adapter = BasePagerAdapter(supportFragmentManager, fragments, titleList)
        viewpager.adapter = adapter
        viewpager.offscreenPageLimit = 4
        viewpager.currentItem = 0
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    viewpager.setCurrentItem(0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_video -> {
                    viewpager.setCurrentItem(1)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_ticket -> {
                    viewpager.setCurrentItem(2)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_my -> {
                    viewpager.setCurrentItem(3)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

}
