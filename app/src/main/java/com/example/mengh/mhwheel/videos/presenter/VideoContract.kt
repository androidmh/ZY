package com.example.mengh.mhwheel.videos.presenter

import com.example.mengh.mhwheel.base.RefreshContract
import com.example.mengh.mhwheel.videos.bean.VideoListBean

interface VideoContract {
    interface view :RefreshContract{
        fun showData(videolist: VideoListBean)
        fun showfailemsg(str: String)
        override fun getLists(isshow: Boolean)
        fun showMoreList(videolist: VideoListBean)
        fun showSearch(videolist: VideoListBean)
    }

    interface presenter {
        fun getVideoList(num:Int)
        fun loadMoreList(url:String)
        fun searchVideos(name:String)
    }
}