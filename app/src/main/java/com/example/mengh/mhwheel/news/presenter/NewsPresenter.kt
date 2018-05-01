package com.example.mengh.mhwheel.news.presenter

import com.example.mengh.mhwheel.base.BaseActivity
import com.example.mengh.mhwheel.news.bean.NewsBean
import com.example.mengh.test.ClientMethods
import com.example.mengh.test.test.DMObserver
import com.example.mengh.test.test.ObserverOnNextListener
import com.example.mengh.test.test.ProgressObserver
/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
class NewsPresenter(private val view: NewsContract.view,private val context: BaseActivity) : NewsContract.presenter{
    //获取新闻列表
    override fun getData() {
        val listener = object : ObserverOnNextListener<NewsBean> {
            override fun onNext(t: NewsBean) {
                if (t.isSuccess){
                view.showData(t.data.news)
                }else{
                    view.showfailemsg(t.msg)
                }
            }
        }
        ClientMethods.getTopNews(ProgressObserver(listener,view))
    }

    //获取搜索新闻列表
    override fun getSearchKey(search: String, view: NewsContract.search) {
        val listener = object : ObserverOnNextListener<NewsBean> {
            override fun onNext(t: NewsBean) {
                view.showSearch(t.data.news)
            }
        }
        ClientMethods.getSearchNews(DMObserver(context,listener),search)
    }
}