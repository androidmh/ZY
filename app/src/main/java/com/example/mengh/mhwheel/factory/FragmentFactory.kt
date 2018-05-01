package com.example.mengh.mhwheel.factory

import android.util.SparseArray
import com.example.mengh.mhwheel.base.BaseFragment
import com.example.mengh.mhwheel.image.ImageFragment
import com.example.mengh.mhwheel.image.ImgListFragment
import com.example.mengh.mhwheel.index.IndexFragment
import com.example.mengh.mhwheel.news.NewsFragment
import com.example.mengh.mhwheel.videos.VideoFragment


/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/9.
 * PS: Not easy to write code, please indicate.
 */
class FragmentFactory {
    companion object {
        private var mFragments = SparseArray<BaseFragment>()
        fun createFragment(position: Int): BaseFragment? {
            var fragment: BaseFragment? = null
            try {
                fragment = mFragments.get(position)
            }catch (e:Exception){

            }

            if (fragment == null) {
                when (position) {
                    0 -> fragment = IndexFragment()

                    1 -> fragment = NewsFragment()

                    2 -> fragment = ImageFragment()

                    3 -> fragment = VideoFragment()

                }

                if (fragment != null) {
                    mFragments.put(position, fragment)
                }
            }

            return fragment
        }
    }

}