package com.example.mengh.mhwheel.news.presenter

import com.example.mengh.mhwheel.base.RefreshContract
import com.example.mengh.mhwheel.news.bean.NewsBean

interface NewsContract{
    interface view :RefreshContract{
        fun showData(newsBean: MutableList<NewsBean.DataBean.News>)
        fun showfailemsg(str: String)
        override fun getLists(isshow: Boolean)
    }


    interface presenter {
        fun getData()
        fun getSearchKey(search: String, view: NewsContract.search)

    }
    interface search {
        fun showSearch(newsBean: MutableList<NewsBean.DataBean.News>)
    }
}