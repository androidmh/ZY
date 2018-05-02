package com.example.mengh.mhwheel.videos.presenter

import com.example.mengh.mhwheel.base.RefreshContract
import com.example.mengh.mhwheel.videos.bean.VideoListBean

interface VideoContract {
    interface view :RefreshContract{
        fun showData(imglist: VideoListBean)
        fun showfailemsg(str: String)
        override fun getLists(isshow: Boolean)
    }

    interface presenter {
        fun getVideoList(num:Int)
    }
}