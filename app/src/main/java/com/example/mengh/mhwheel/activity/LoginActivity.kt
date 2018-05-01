package com.example.mengh.mhwheel.activity

import android.animation.ObjectAnimator
import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.animation.LinearInterpolator
import android.widget.Toast
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.BaseActivity
import com.vondear.rxtools.RxAnimationTool
import com.vondear.rxtools.RxBarTool
import com.vondear.rxtools.RxKeyboardTool
import com.vondear.rxtools.activity.AndroidBug5497Workaround
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_login
    var screenHeight = 0//屏幕高度
    var keyHeight = 0 //软件盘弹起后所占高度


    override fun initParms(parms: Bundle?) {
    }


    override fun initView(view: View) {
        RxBarTool.StatusBarLightMode(mContext)
        if (isFullScreen(this)) {
            AndroidBug5497Workaround.assistActivity(this)
        }
        screenHeight = this.resources.displayMetrics.heightPixels //获取屏幕高度
        keyHeight = screenHeight / 3//弹起高度为屏幕高度的1/3
        initEvent()
    }

    private fun initEvent() {
        et_mobile.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (!TextUtils.isEmpty(s) && iv_clean_phone.getVisibility() == View.GONE) {
                    iv_clean_phone.setVisibility(View.VISIBLE)
                } else if (TextUtils.isEmpty(s)) {
                    iv_clean_phone.setVisibility(View.GONE)
                }
            }
        })
        et_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (!TextUtils.isEmpty(s) && clean_password.getVisibility() == View.GONE) {
                    clean_password.setVisibility(View.VISIBLE)
                } else if (TextUtils.isEmpty(s)) {
                    clean_password.setVisibility(View.GONE)
                }
                if (s.toString().isEmpty())
                    return
                if (!s.toString().matches("[A-Za-z0-9]+".toRegex())) {
                    val temp = s.toString()
                    Toast.makeText(mContext, "请输入数字或字母", Toast.LENGTH_SHORT).show()
                    s.delete(temp.length - 1, temp.length)
                    et_password.setSelection(s.length)
                }
            }
        })
        /**
         * 禁止键盘弹起的时候可以滚动
         */
        scrollView.setOnTouchListener(View.OnTouchListener { v, event -> true })
        scrollView.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
            override fun onLayoutChange(v: View, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
                /* old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值
              现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起*/
                if (oldBottom != 0 && bottom != 0 && oldBottom - bottom > keyHeight) {
                    Log.e("wenzhihao", "up------>" + (oldBottom - bottom))
                    val dist = content.getBottom() - bottom
                    if (dist > 0) {
                        val mAnimatorTranslateY = ObjectAnimator.ofFloat(content, "translationY", 0.0f, -dist.toFloat())
                        mAnimatorTranslateY.duration = 300
                        mAnimatorTranslateY.interpolator = LinearInterpolator()
                        mAnimatorTranslateY.start()
                        RxAnimationTool.zoomIn(logo, 0.6f, dist.toFloat())
                    }
                    service.setVisibility(View.INVISIBLE)

                } else if (oldBottom != 0 && bottom != 0 && bottom - oldBottom > keyHeight) {
                    Log.e("wenzhihao", "down------>" + (bottom - oldBottom))
                    if (content.getBottom() - oldBottom > 0) {
                        val mAnimatorTranslateY = ObjectAnimator.ofFloat(content, "translationY", content.getTranslationY(), Float.MIN_VALUE)
                        mAnimatorTranslateY.setDuration(300)
                        mAnimatorTranslateY.setInterpolator(LinearInterpolator())
                        mAnimatorTranslateY.start()
                        //键盘收回后，logo恢复原来大小，位置同样回到初始位置
                        RxAnimationTool.zoomOut(logo, 0.6f)
                    }
                    service.setVisibility(View.VISIBLE)
                }
            }
        })

        btn_login.setOnClickListener(View.OnClickListener { RxKeyboardTool.hideSoftInput(mContext) })
    }

    fun isFullScreen(activity: Activity): Boolean {
        return activity.window.attributes.flags and WindowManager.LayoutParams.FLAG_FULLSCREEN == WindowManager.LayoutParams.FLAG_FULLSCREEN
    }

    override fun setListener() {
        iv_clean_phone.setOnClickListener(this)
        clean_password.setOnClickListener(this)
        iv_show_pwd.setOnClickListener(this)
        btn_login.setOnClickListener(this)
    }

    override fun widgetClick(v: View) {
        when (v) {
            iv_clean_phone -> et_mobile.setText("")
            clean_password -> et_password.setText("")
            iv_show_pwd -> showPsd()
            btn_login -> {
                startsActivity(MainActivity::class.java)
                finish()
            }
        }
    }

    private fun showPsd() {
        if (et_password.getInputType() != InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
            et_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
            iv_show_pwd.setImageResource(R.drawable.pass_visuable)
        } else {
            et_password.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
            iv_show_pwd.setImageResource(R.drawable.pass_gone)
        }
        val pwd = et_password.getText().toString()
        if (!TextUtils.isEmpty(pwd))
            et_password.setSelection(pwd.length)
    }
}
