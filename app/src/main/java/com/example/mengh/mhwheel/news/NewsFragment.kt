package com.example.mengh.mhwheel.news

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arlib.floatingsearchview.FloatingSearchView
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.BaseFragment
import com.example.mengh.mhwheel.base.ProjectConstant.Companion.KEY_NEWS
import com.example.mengh.mhwheel.news.adapter.NewsAdapter
import com.example.mengh.mhwheel.news.bean.NewsBean
import com.example.mengh.mhwheel.news.bean.NewsSearchSuggestion
import com.example.mengh.mhwheel.news.presenter.NewsContract
import com.example.mengh.mhwheel.news.presenter.NewsPresenter
import kotlinx.android.synthetic.main.fragment_news.*
import java.util.*

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
class NewsFragment : BaseFragment(), NewsContract.view, NewsContract.search {


    lateinit var newsPresenter: NewsPresenter

    override val layoutId: Int
        get() = R.layout.fragment_news


    override fun doBusiness(mContext: Context?) {
        newsPresenter = NewsPresenter(this, this.mactivity!!)
        newsPresenter.getData()
        setSearch()
    }

    override fun widgetClick(v: View) {
    }


    override fun showData(newsBean: MutableList<NewsBean.DataBean.News>) {
        setRecy(newsBean)
    }

    override fun showSearch(newsBean: MutableList<NewsBean.DataBean.News>) {
        if (newsBean.size == 0) {
            mactivity!!.showToast("抱歉没有找到相关信息", 3)
        } else {
            setRecy(newsBean)
        }
        sl_news.isRefreshing = false
    }

    /**
     * 搜索栏相关设置
     */
    private fun setSearch() {
        //监听输入字符
        search_view.setOnQueryChangeListener( { oldQuery, newQuery ->
            if (oldQuery != "" && newQuery == "") run {
                search_view.clearSuggestions()
            } else {
                //设置加载进度
                search_view.showProgress()
                val search: NewsContract.search = object : NewsContract.search {
                    //实现模糊搜索的方法，动态检查测输入字符并搜索关键字
                    override fun showSearch(newsBean: MutableList<NewsBean.DataBean.News>) {
                        //这里的判断是由有些关键字搜索不到，而且有的关键字返回的条目不一致，如果需要展示全部搜索数据可把判断去掉
                        if (newsBean.size != 0) {
                            var list = ArrayList<NewsSearchSuggestion>()
                            if (newsBean.size >= 3) {
                                for (i in 0..2) {
                                    //由于有些搜索的标题过长，所以设置长度限制并添加...为结尾
                                    list.add(NewsSearchSuggestion(newsBean[i].title.substring(0, 12) + "..."))
                                }
                            } else {
                                for (news in newsBean) {
                                    list.add(NewsSearchSuggestion(news.title.substring(0, 12) + "..."))
                                }
                            }
                            //设置搜索内容
                            search_view.swapSuggestions(list)
                        }
                        //隐藏搜索进度
                        search_view.hideProgress()
                    }
                }
                newsPresenter.getSearchKey(newQuery, search)

            }
        })
        search_view.setOnSearchListener(object : FloatingSearchView.OnSearchListener {
            //处理推荐搜索点击
            override fun onSuggestionClicked(searchSuggestion: SearchSuggestion) {
                sl_news.isRefreshing = true
                newsPresenter.getSearchKey(searchSuggestion.body, this@NewsFragment)
            }

            //处理搜索点击事件
            override fun onSearchAction(query: String) {
                newsPresenter.getSearchKey(query, this@NewsFragment)
                sl_news.isRefreshing = true
            }
        })
        //处理搜索栏聚焦与失焦的监听
        search_view.setOnFocusChangeListener(object : FloatingSearchView.OnFocusChangeListener {
            //聚焦
            override fun onFocus() {
                //清空搜索记录
                search_view.clearQuery()
                //添加相关推荐 由于接口限制这里的推荐是我本地设置的，可根据需求自行改变
                var list = ArrayList<NewsSearchSuggestion>()
                list.add(NewsSearchSuggestion("体育"))
                list.add(NewsSearchSuggestion("娱乐"))
                list.add(NewsSearchSuggestion("财经"))
                search_view.swapSuggestions(list)
            }

            //失焦
            override fun onFocusCleared() {
            }
        })
        //设置搜索栏启动后动态使recycleview向下移动
//        search_view.setOnSuggestionsListHeightChanged(FloatingSearchView.OnSuggestionsListHeightChanged { newHeight -> rv_news.setTranslationY(newHeight) })
    }

    private fun setRecy(news: MutableList<NewsBean.DataBean.News>) {
        var adapter = NewsAdapter(R.layout.item_news_fragment, news)
        val layoutManager = LinearLayoutManager(mactivity)
        rv_news.layoutManager = layoutManager
        rv_news.adapter = adapter
        adapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener({ adapter, view, position ->
            var bundle = Bundle()
            bundle.putString(KEY_NEWS, news[position].url)
            startActivityf(NewsActivity::class.java, bundle)
        })
        sl_news.setOnRefreshListener( { newsPresenter.getData() })
    }

    override fun showfailemsg(str: String) {
        mactivity!!.showToast(str, 1)
    }

    override fun getLists(isshow: Boolean) {
        sl_news.isRefreshing = isshow
    }


}