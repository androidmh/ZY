package com.example.mengh.mhwheel.image.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.image.bean.ImageListBean
import com.example.mengh.mhwheel.utils.GlideUtil

class ImageListAdapter(layoutResId: Int, data: MutableList<ImageListBean.DataBean>) : BaseQuickAdapter<ImageListBean.DataBean, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder?, item: ImageListBean.DataBean?) {
        val iv_img = helper!!.getView<ImageView>(R.id.iv_img)
        GlideUtil.LoadImg(mContext,item!!.thumbnail_url,iv_img)
    }
}