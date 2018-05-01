package com.example.mengh.mhwheel.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.GlideApp

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
class GlideUtil {
    companion object {
        var options: RequestOptions = RequestOptions()
                        .placeholder(R.mipmap.loading)
        fun LoadImg(activity: Context, url: String, imageView: ImageView) {
            GlideApp.with(activity)
                    .load(url)
                    .apply(options)
                    .transition(DrawableTransitionOptions().crossFade(500))
                    .fitCenter()
                    .into(imageView)
        }
    }
}