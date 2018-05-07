package com.example.mengh.mhwheel.videos.presenter

import com.example.mengh.mhwheel.base.BaseActivity
import com.example.mengh.mhwheel.videos.bean.VideoListBean
import com.example.mengh.test.ClientMethods
import com.example.mengh.test.test.DMObserver
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

    override fun loadMoreList(url: String) {
        val listener = object : ObserverOnNextListener<VideoListBean> {
            override fun onNext(t: VideoListBean) {
                if (t != null) {
                    view.showMoreList(t)
                }else{
                    view.showfailemsg("")
                }
            }
        }
        ClientMethods.getVideoLoadmore(DMObserver(context, listener), url)
    }

    override fun searchVideos(name: String) {
        val listener = object : ObserverOnNextListener<VideoListBean> {
            override fun onNext(t: VideoListBean) {
                view.showSearch(t)
            }
        }
        ClientMethods.getsearchVideo(DMObserver(context,listener),name)
    }
}