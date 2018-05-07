package com.example.mengh.mhwheel.view

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import com.example.mengh.mhwheel.R
import kotlinx.android.synthetic.main.dm_auto_imageview.view.*

/**
 * @author HDM
 * 自动左右平滑移动的ImageView
 */
class DMAutoImageView : FrameLayout {

    lateinit var  mImageView: ImageView

    internal var resId: Int = 0

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        //导入布局
        initView(context, attrs)
    }

    fun getmImageView(): ImageView? {
        if (mImageView != null) {
            return mImageView
        } else {
            mImageView = iv_backgroud
        }
        return mImageView
    }

    private fun initView(context: Context, attrs: AttributeSet) {
        LayoutInflater.from(context).inflate(R.layout.dm_auto_imageview, this)

        mImageView = iv_backgroud

        //获得这个控件对应的属性
        val a = getContext().obtainStyledAttributes(R.styleable.DMAutoImageView)

        try {
            //获得属性值
            resId = a.getResourceId(R.styleable.DMAutoImageView_image_src, 0)
        } finally {
            //回收这个对象
            a.recycle()
        }

        if (resId != 0) {
            mImageView!!.setImageResource(resId)
        }

        Handler().postDelayed({
            val animation = AnimationUtils.loadAnimation(context, R.anim.translate_autoimg)
            mImageView!!.startAnimation(animation)
        }, 200)
    }
}
