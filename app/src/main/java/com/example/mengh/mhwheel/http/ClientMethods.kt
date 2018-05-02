package com.example.mengh.test


import com.example.mengh.mhwheel.image.bean.ImageListBean
import com.example.mengh.mhwheel.news.bean.NewsBean
import com.example.mengh.mhwheel.videos.bean.VideoListBean
import com.example.mengh.test.test.DMObserver
import com.example.mengh.test.test.ProgressObserver
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
object ClientMethods {

    /**
     * 封装线程管理和订阅的过程
     */

    fun <T> ApiSubscribe(observable: Observable<T>, observer: ProgressObserver<T>) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
    fun <T> ApiSubscribe(observable: Observable<T>, observer: DMObserver<T>) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    //获取新闻
    fun getTopNews(observer: ProgressObserver<NewsBean>) {
        ApiSubscribe(Client.getClient(1).getTopNews(), observer)
    }
    //搜索新闻
    fun getSearchNews(observer: DMObserver<NewsBean>,search: String) {
        ApiSubscribe(Client.getClient(1).getSearchNews(search), observer)
    }
    //获取图片列表
    fun getImgList(observer: ProgressObserver<ImageListBean>, page: Int, pagenum: Int, tag: String) {
        ApiSubscribe(Client.getClient(2).getImgList(page,pagenum,tag), observer)
    }
    //加载更多图片
    fun getImgLoadmore(observer: DMObserver<ImageListBean>, page: Int, pagenum: Int, tag: String) {
        ApiSubscribe(Client.getClient(2).getImgList(page,pagenum,tag), observer)
    }
    //加载更多图片
    fun getVideoList(observer: ProgressObserver<VideoListBean>, page: Int) {
        ApiSubscribe(Client.getClient(3).getVideoList(page), observer)
    }
}
