package com.example.mengh.mhwheel.videos.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.hmh.gonlayout.utils.KTUtils
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.index.item.IndexItem
import com.example.mengh.mhwheel.loader.GlideImageLoader
import com.example.mengh.mhwheel.utils.GlideUtil
import com.example.mengh.mhwheel.videos.item.VideoItem
import com.youth.banner.Banner
import java.util.*

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */

class VideoAdapter(data: MutableList<VideoItem>?) : BaseMultiItemQuickAdapter<VideoItem, BaseViewHolder>(data) {


    init {
        addItemType(IndexItem.IMG, R.layout.item_index_vp)
        addItemType(IndexItem.LAYOUT, R.layout.item_video)
    }

    override fun convert(helper: BaseViewHolder?, item: VideoItem?) {
        when (helper?.itemViewType) {
            IndexItem.IMG -> {
                val localImages = ArrayList<String>()
                val itemList = item!!.getData()!!.data.itemList
                for (itemListBean in itemList) {
                    localImages.add(itemListBean.data.image)
                }
                val banner = helper.getView(R.id.banner)as Banner
                banner.setImageLoader(GlideImageLoader())
                //设置图片集合
                banner.setImages(localImages)
                //banner设置方法全部调用完毕时最后调用
                banner.start()
            }
            IndexItem.LAYOUT -> {
                helper.setText(R.id.tv_collection, item!!.getData()!!.data.consumption.collectionCount.toString())
                helper.setText(R.id.tv_share, item.getData()!!.data.consumption.shareCount.toString())
                helper.setText(R.id.tv_reply, item.getData()!!.data.consumption.replyCount.toString())
                helper.setText(R.id.tv_video_title, item.getData()!!.data.title)
                var tags = StringBuilder()
                for (tag in item.getData()!!.data.tags) {

                    tags.append("  #${tag.name}")

                }
                helper.setText(R.id.tv_video_tag, tags)
                val duration = item.getData()!!.data.duration
                helper.setText(R.id.tv_time,KTUtils.secToTime(duration))
                val iv_video = helper.getView<ImageView>(R.id.iv_video)
                GlideUtil.loadImg(mContext, item.getData()!!.data.cover.feed,iv_video)
            }
        }
    }

}