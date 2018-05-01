package com.example.mengh.mhwheel.index.adapter

import android.view.View
import android.view.ViewGroup
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.R.id.convenientBanner
import com.example.mengh.mhwheel.index.bean.LocalImageHolderView
import com.example.mengh.mhwheel.index.item.IndexItem
import java.util.ArrayList

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
                val convenientBanner = helper.getView(R.id.convenientBanner)as ConvenientBanner<Any>
                convenientBanner.setPages(
                        CBViewHolderCreator { LocalImageHolderView() }, localImages as List<Any>?)
                        //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                        .setPageIndicator(intArrayOf(R.drawable.dot,R.drawable.nodot))
                        //设置指示器的方向
                        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                        .startTurning(2000)
            }
            IndexItem.LAYOUT -> {
                helper.setText(R.id.tv_no, item?.getData()?.orderNo)
                helper.setText(R.id.tv_info, item?.getData()?.orderInfo)
            }
        }
    }

}