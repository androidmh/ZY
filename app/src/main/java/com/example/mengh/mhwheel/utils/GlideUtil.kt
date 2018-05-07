package com.example.mengh.mhwheel.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.GlideApp
import com.example.mengh.mhwheel.base.GlideOptions.bitmapTransform
import jp.wasabeef.glide.transformations.BlurTransformation

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
object GlideUtil {
    //glide相关设置
    var options: RequestOptions = RequestOptions()
            .placeholder(R.mipmap.loading)
            .fitCenter()

    /**
     * @param activity 上下文
     * @param url 加载地址
     * @param imageView 加载imageview
     * 普通加载图片
     */
    fun LoadImg(activity: Context, url: String, imageView: ImageView) {
        GlideApp.with(activity)
                .load(url)
                .apply(options)
                .transition(DrawableTransitionOptions().crossFade(500))
                .into(imageView)
    }

    /**
     * @param activity 上下文
     * @param url 加载地址
     * @param imageView 加载imageview
     * 模糊加载图片
     */
    fun LoadvagueImg(activity: Context, url: String, imageView: ImageView) {
        GlideApp.with(activity)
                .load(url)
                .apply(options)
                .skipMemoryCache(true) // 不使用内存缓存
                .diskCacheStrategy(DiskCacheStrategy.NONE) // 不使用磁盘缓存
                .apply(bitmapTransform(BlurTransformation(23,8)))
                .transition(DrawableTransitionOptions().crossFade(500))
                .into(imageView)
    }
}