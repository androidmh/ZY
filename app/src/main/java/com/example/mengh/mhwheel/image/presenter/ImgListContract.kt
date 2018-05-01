package com.example.mengh.mhwheel.image.presenter

import com.example.mengh.mhwheel.base.RefreshContract
import com.example.mengh.mhwheel.image.bean.ImageListBean

interface ImgListContract {
    interface view :RefreshContract{
        fun showData(imglist: MutableList<ImageListBean.DataBean>)
        fun showfailemsg(str: String)
        override fun getLists(isshow: Boolean)
        fun showMoreList(imglist: MutableList<ImageListBean.DataBean>)
    }

    interface presenter {
        fun getImgList(page:Int, pagenum: Int, tag:String)
        fun loadMoreList(page:Int, pagenum: Int, tag:String)
    }
}