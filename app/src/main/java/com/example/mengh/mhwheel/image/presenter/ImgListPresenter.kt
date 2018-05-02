package com.example.mengh.mhwheel.image.presenter

import com.example.mengh.mhwheel.base.BaseActivity
import com.example.mengh.mhwheel.image.bean.ImageListBean
import com.example.mengh.test.ClientMethods
import com.example.mengh.test.test.DMObserver
import com.example.mengh.test.test.ObserverOnNextListener
import com.example.mengh.test.test.ProgressObserver

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
class ImgListPresenter(private val view: ImgListContract.view, private val context: BaseActivity) :ImgListContract.presenter{

    override fun getImgList(page: Int, pagenum: Int, tag: String) {
        val listener = object : ObserverOnNextListener<ImageListBean> {
            override fun onNext(t: ImageListBean) {
                val data = t.data
                if (data.size == 0) {
                    view.showfailemsg("无")
                } else {
                    view.showData(data)
                }
            }
        }
        ClientMethods.getImgList(ProgressObserver( listener, view), page, pagenum, tag)
    }

    override fun loadMoreList(page: Int, pagenum: Int, tag: String) {
        val listener = object : ObserverOnNextListener<ImageListBean> {
            override fun onNext(t: ImageListBean) {
                val data = t.data
                if (data.size == 0) {
                    view.showfailemsg("无")
                } else {
                    view.showMoreList(data)
                }
            }
        }
        ClientMethods.getImgLoadmore(DMObserver(context, listener), page, pagenum, tag)
    }

}