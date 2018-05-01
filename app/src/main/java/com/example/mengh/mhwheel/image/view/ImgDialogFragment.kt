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

@SuppressLint("ValidFragment")
/**
 * Created by HMH on 2017/8/17.
 */

class ImgDialogFragment(imageurl:String,thumbnail_url:String) : DialogFragment() {
    //图片路径
    private var imageurl = imageurl;
    //缩略图路径
    private var thumbnail_url = thumbnail_url;
    override fun onStart() {
        super.onStart()

        // safety check
        if (dialog == null) {
            return
        }

        // set the animations to use on showing and hiding the dialog
        dialog.window!!.setWindowAnimations(
                R.style.DialogAnimation)
        // alternative way of doing it
        //getDialog().getWindow().getAttributes().
        //    windowAnimations = R.style.dialog_animation_fade;

        // ... other stuff you want to do in your onStart() method
            setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo);
    }

    override fun onResume() {
        super.onResume()
        //动态设置dialog大小
//        dialog.window!!.setLayout(750, 600)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        val v = inflater.inflate(R.layout.dialog_img, null)
       var img:ImageView = v.findViewById(R.id.iv_pic)
        GlideUtil.LoadImg(activity as BaseActivity,imageurl,img)

        img.setOnClickListener({
            this.dismiss()
        })
        return v
    }


}
