package com.example.mengh.mhwheel.videos

import android.os.Bundle
import android.view.View
import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.BaseActivity
import com.example.mengh.mhwheel.base.Constant.Companion.VIDEO_KEY
import com.example.mengh.mhwheel.utils.GlideUtil
import com.example.mengh.mhwheel.videos.bean.VideoListBean
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : BaseActivity() {

    //传过来的视频相关数据
    lateinit var videobean:VideoListBean.ItemListBeanX

    /**
     * @param parms 传过来的数据
     * 获取bundle里传过来的数据
     */
    override fun initParms(parms: Bundle?) {
        if (parms != null) {
            videobean = parms.getSerializable(VIDEO_KEY) as VideoListBean.ItemListBeanX
        }
    }

    //加载布局
    override val layoutId: Int
        get() = R.layout.activity_video

    /**
     * 初始化数据
     */
    override fun initView(view: View) {
        //加载视频相关选项
        videoplayer.setUp(videobean.data.playUrl, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,videobean.data.title)
        //设置视频插图
        GlideUtil.loadvagueImg(this,videobean.data.cover.feed,videoplayer.thumbImageView)
        //加载底部浮动图片
        GlideUtil.loadImg(this,videobean.data.cover.feed, iv_auto.getmImageView()!!)
        //设置视频标题
        tv_title.text = videobean.data.title
        //设置视频介绍
        tv_info.text = videobean.data.description
    }

    override fun setListener() {

    }

    override fun widgetClick(v: View) {
    }

    override fun onPause() {
        super.onPause()
        if (JZVideoPlayer.backPress()) {
            return
        }
        JZVideoPlayer.releaseAllVideos()
    }

    override fun onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return
        }
        super.onBackPressed()
    }
}
