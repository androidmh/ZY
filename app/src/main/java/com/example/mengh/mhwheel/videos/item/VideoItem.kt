package com.example.mengh.mhwheel.videos.item

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.mengh.mhwheel.videos.bean.VideoListBean

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/11.
 * PS: Not easy to write code, please indicate.
 */
class VideoItem (itemType: Int, data: VideoListBean.ItemListBeanX?): MultiItemEntity{
    companion object {
        val IMG = 1
        val  LAYOUT= 2
    }
    private val data: VideoListBean.ItemListBeanX? = data
    private val itemType: Int = itemType


    override fun getItemType(): Int {
        return itemType
    }
    open fun getData(): VideoListBean.ItemListBeanX? {
        return data
    }
}