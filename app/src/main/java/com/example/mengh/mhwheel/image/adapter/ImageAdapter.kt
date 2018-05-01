package com.example.mengh.mhwheel.image.adapter


import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import com.example.mengh.mhwheel.base.LazyLoadFragment
import java.util.ArrayList

/**
 * Created by HDM on 2017/12/20.
 * E-mail menghedianmo@163.com
 * author HDM
 */

class ImageAdapter(fm: FragmentManager, private val fragments: ArrayList<LazyLoadFragment>, private val tabTileList: List<String>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): LazyLoadFragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    //设置tablayout标题
    override fun getPageTitle(position: Int): CharSequence? {
        return tabTileList[position]

    }
}