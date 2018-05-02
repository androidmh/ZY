package com.example.mengh.mhwheel.videos.presenter

import com.example.mengh.mhwheel.base.BaseActivity
import com.example.mengh.mhwheel.videos.bean.VideoListBean
import com.example.mengh.test.ClientMethods
import com.example.mengh.test.test.ObserverOnNextListener
import com.example.mengh.test.test.ProgressObserver

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
class VideoPresenter(private val view: VideoContract.view, private val context: BaseActivity) : VideoContract.presenter {
    override fun getVideoList(num: Int) {
        val listener = object : ObserverOnNextListener<VideoListBean> {
            override fun onNext(t: VideoListBean) {
                if (t.itemList.size != 0 && t.itemList != null) {
                    view.showData(t)
                } else {
                    view.showfailemsg("")
                }
            }
        }
        ClientMethods.getVideoList(ProgressObserver(listener, view), num)
    }

}