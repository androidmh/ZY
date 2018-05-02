package com.example.mengh.mhwheel.index.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.index.item.IndexItem
import com.example.mengh.mhwheel.loader.GlideImageLoader
import com.youth.banner.Banner
import java.util.*



/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */

class IndexAdapter(data: MutableList<IndexItem>?) : BaseMultiItemQuickAdapter<IndexItem, BaseViewHolder>(data) {
    init {
        addItemType(IndexItem.IMG, R.layout.item_index_vp)
        addItemType(IndexItem.LAYOUT, R.layout.item_index)
    }

    override fun convert(helper: BaseViewHolder?, item: IndexItem?) {
        when (helper?.itemViewType) {
            IndexItem.IMG -> {
                val localImages = ArrayList<Int>()
                localImages.add(R.mipmap.banner1)
                localImages.add(R.mipmap.banner2)
                localImages.add(R.mipmap.banner3)
                localImages.add(R.mipmap.banner4)
                localImages.add(R.mipmap.banner5)
                val banner = helper.getView(R.id.banner)as Banner
                banner.setImageLoader(GlideImageLoader())
                //设置图片集合
                banner.setImages(localImages)
                //banner设置方法全部调用完毕时最后调用
                banner.start()
        }
    }

}}