package com.example.mengh.mhwheel.activity

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/9.
 * PS: Not easy to write code, please indicate.
 */
import android.os.Bundle
import android.view.View
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.BaseActivity
import com.example.mengh.mhwheel.factory.FragmentFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun widgetClick(v: View) {
    }

    override fun initParms(parms: Bundle?) {
    }


    override fun initView(view: View) {
        setTab()
    }

    private fun setTab() {
        bottomBar.setOnTabSelectListener { tabId ->
            val ft = supportFragmentManager.beginTransaction()
            when (tabId) {

//                R.id.tab_index -> {
//                    ft.replace(R.id.ff, FragmentFactory.createFragment(0))
//                }
                R.id.tab_news -> {
                    ft.replace(R.id.ff, FragmentFactory.createFragment(1))
                }
                R.id.tab_img -> {
                    ft.replace(R.id.ff, FragmentFactory.createFragment(2))
                }

                R.id.tab_videos -> {
                    ft.replace(R.id.ff, FragmentFactory.createFragment(3))
                }

            }
            ft.commit()
        }
    }

    override fun setListener() {
    }


}
