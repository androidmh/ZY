package com.example.mengh.mhwheel.image.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.BaseActivity
import com.example.mengh.mhwheel.utils.GlideUtil
import kotlinx.android.synthetic.main.dialog_img.*

@SuppressLint("ValidFragment")
/**
 * Created by HMH on 2017/8/17.
 */

class ImgDialogFragment(imageurl:String,thumbnail_url:String) : DialogFragment() {
    //图片路径
    private var imageurl = imageurl;

    override fun onStart() {
        super.onStart()
        if (dialog == null) {
            return
        }

        dialog.window!!.setWindowAnimations(
                R.style.DialogAnimation)
            setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo);
    }

//    override fun onResume() {
//        super.onResume()
//        //动态设置dialog大小
////        dialog.window!!.setLayout(1750, 1600)
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        val v = inflater.inflate(R.layout.dialog_img, ll_dialogf)
       var img:ImageView = v.findViewById(R.id.iv_pic)
        GlideUtil.loadImg(activity as BaseActivity,imageurl,img)

        img.setOnClickListener({
            this.dismiss()
        })
        return v
    }


}
