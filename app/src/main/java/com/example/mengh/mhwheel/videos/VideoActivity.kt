package com.example.mengh.mhwheel.videos

import android.os.Bundle
import android.view.View
import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.BaseActivity
import com.example.mengh.mhwheel.base.Constant.Companion.VIDEO_KEY
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : BaseActivity() {
    lateinit var urlArray:ArrayList<String>
    override fun initParms(parms: Bundle?) {
        if (parms != null) {
            urlArray = parms.getStringArrayList(VIDEO_KEY)
        }
    }

    override val layoutId: Int
        get() = R.layout.activity_video

    override fun initView(view: View) {
        videoplayer.setUp(urlArray[0], JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,"haha")
    }

    override fun setListener() {
    }

    override fun widgetClick(v: View) {
    }

    override fun onPause() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        JZVideoPlayer.releaseAllVideos()
        super.onPause()
    }

    override fun onBackPressed() {

        super.onBackPressed()
    }
}
