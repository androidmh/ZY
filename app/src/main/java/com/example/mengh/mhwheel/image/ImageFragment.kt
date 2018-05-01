package com.example.mengh.mhwheel.image

import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.BaseFragment
import com.example.mengh.mhwheel.base.Constant.Companion.IMG_TAB
import com.example.mengh.mhwheel.base.Constant.Companion.TAB_KEY
import com.example.mengh.mhwheel.base.LazyLoadFragment
import com.example.mengh.mhwheel.image.adapter.ImageAdapter
import kotlinx.android.synthetic.main.fragment_img.*
import java.util.ArrayList

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
class ImageFragment : BaseFragment() {

    override val layoutId: Int
        get() = R.layout.fragment_img

    override fun doBusiness(mContext: Context?) {
        initTab()
    }

    private fun initTab() {

        val fragments = ArrayList<LazyLoadFragment>()
        val list = ArrayList<String>()
        for (tab in IMG_TAB) {
            val bundle = Bundle()
            bundle.putString(TAB_KEY, tab)
            val imgListFragment = ImgListFragment()
            imgListFragment.arguments = bundle
            fragments.add(imgListFragment)
            list.add(tab)
        }
        val adapter = ImageAdapter(childFragmentManager, fragments, list)
        vp_imgfragment.adapter = adapter
        //将TabLayout和ViewPager关联起来。
        tab_imgfragment.setupWithViewPager(vp_imgfragment)
    }

    override fun widgetClick(v: View) {
    }
}