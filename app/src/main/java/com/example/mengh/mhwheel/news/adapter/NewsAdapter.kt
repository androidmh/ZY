package com.example.mengh.mhwheel.news.adapter

import android.view.View
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.news.bean.NewsBean
import com.example.mengh.mhwheel.utils.GlideUtil
import com.example.mengh.mhwheel.utils.MHUtils

class NewsAdapter(layoutResId: Int, data: MutableList<NewsBean.DataBean.News>) : BaseQuickAdapter<NewsBean.DataBean.News, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder?, item: NewsBean.DataBean.News?) {
        helper!!.setText(R.id.tv_title, item!!.title)
        val iv_thumb = helper.getView<ImageView>(R.id.iv_thumb)
        val iv_thumb2 = helper.getView<ImageView>(R.id.iv_thumb2)
        val iv_thumb3 = helper.getView<ImageView>(R.id.iv_thumb3)
        helper.setText(R.id.tv_sourceName,"来源:${item.source}")
        helper.setText(R.id.tv_newstime,"日期:${MHUtils.timeStrToSecond(item.gmt_publish)}")
        try {

            if (item.thumbnail_img.size == 1) {
                GlideUtil.loadImg(mContext,item.thumbnail_img[0],iv_thumb)
                iv_thumb2.visibility = View.GONE
                iv_thumb3.visibility = View.GONE
            } else if (item.thumbnail_img.size == 2) {
                iv_thumb3.visibility = View.GONE
                GlideUtil.loadImg(mContext,item.thumbnail_img[0],iv_thumb)
                GlideUtil.loadImg(mContext,item.thumbnail_img[1],iv_thumb2)
            } else {
                GlideUtil.loadImg(mContext,item.thumbnail_img[0],iv_thumb)
                GlideUtil.loadImg(mContext,item.thumbnail_img[1],iv_thumb2)
                GlideUtil.loadImg(mContext,item.thumbnail_img[2],iv_thumb3)

            }
        } catch (e: Exception) {
            iv_thumb.setImageResource(R.mipmap.noimg)
            iv_thumb2.visibility = View.GONE
            iv_thumb3.visibility = View.GONE
        }

    }
}