package com.example.mengh.mhwheel.videos

import android.content.Context
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.BaseFragment
import com.example.mengh.mhwheel.base.Constant.Companion.VIDEO_KEY
import com.example.mengh.mhwheel.image.view.ImgDialogFragment
import com.example.mengh.mhwheel.index.item.IndexItem
import com.example.mengh.mhwheel.videos.adapter.VideoAdapter
import com.example.mengh.mhwheel.videos.bean.VideoListBean
import com.example.mengh.mhwheel.videos.item.VideoItem
import com.example.mengh.mhwheel.videos.presenter.VideoContract
import com.example.mengh.mhwheel.videos.presenter.VideoPresenter
import kotlinx.android.synthetic.main.fragment_imglist.*
import kotlinx.android.synthetic.main.fragment_videos.*


/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
class VideoFragment : BaseFragment(), VideoContract.view {

    lateinit var videoPresenter: VideoPresenter


    lateinit var adapter: VideoAdapter

    var pagnum: Int = 16

    override val layoutId: Int
        get() = R.layout.fragment_videos

    override fun doBusiness(mContext: Context?) {
        videoPresenter = VideoPresenter(this, this!!.mactivity!!)
        videoPresenter.getVideoList(pagnum)
    }

    override fun widgetClick(v: View) {
    }

    override fun showData(videoList: VideoListBean) {
        setRecy(videoList.itemList)
    }

    private fun setRecy(itemList: List<VideoListBean.ItemListBeanX>) {
        var data: MutableList<VideoItem> = ArrayList()
        for (itemListBeanX in itemList) {
            if (itemListBeanX.type.equals("horizontalScrollCard")){
                data.add(VideoItem(VideoItem.IMG,itemListBeanX))
            }else if (itemListBeanX.type.equals("video")){
                data.add(VideoItem(VideoItem.LAYOUT,itemListBeanX))
            }
        }
        adapter = VideoAdapter(data)
        val layoutManager = LinearLayoutManager(mactivity)
        rv_video.layoutManager = layoutManager
        rv_video.adapter = adapter;
        adapter.setOnItemClickListener(BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            var bundle = Bundle()
            var list: MutableList<String> = ArrayList()
            for (playInfoBean in data[position].getData()!!.data.playInfo) {
                list.add(playInfoBean.url)
            }
            bundle.putStringArrayList(VIDEO_KEY, list as java.util.ArrayList<String>?)
            startActivityf(VideoActivity::class.java,bundle)
        })

        //下拉刷新
        sl_video.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            videoPresenter.getVideoList(pagnum)
        })
    }

    override fun showfailemsg(str: String) {
        mactivity!!.showToast(str, 1)
    }

    override fun getLists(isshow: Boolean) {
        if (isshow) {
            sl_video.isRefreshing = true
        } else {
            sl_video.isRefreshing = false
        }
    }
}