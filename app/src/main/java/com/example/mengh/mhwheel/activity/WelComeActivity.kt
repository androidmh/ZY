package com.example.mengh.mhwheel.activity
/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/9.
 * PS: Not easy to write code, please indicate.
 */
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.BaseActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import java.util.*


class WelComeActivity : BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_welcome
    var recLen = 5//跳过倒计时提示5秒
    var timer = Timer()
    override fun widgetClick(v: View) {
        when (v) {
            tv_wel -> toMain()
        }
    }

    private fun toMain() {
        startsActivity(LoginActivity::class.java)
        task.cancel()
        finish()
    }

    override fun initParms(parms: Bundle?) {
    }



    override fun initView(view: View) {
        val flag = WindowManager.LayoutParams.FLAG_FULLSCREEN
        getWindow().setFlags(flag, flag);
        timer.schedule(task, 1000, 1000);//等待时间一秒，停顿时间一秒
    }

    var task: TimerTask = object : TimerTask() {
        override fun run() {
            runOnUiThread {
                recLen--
                tv_wel.setText("跳过 $recLen")
                if (recLen < 0) {
                    timer.cancel()
                    tv_wel.setVisibility(View.GONE)//倒计时到0隐藏字体
                    toMain()
                }
            }
        }
    }

    override fun setListener() {
        tv_wel.setOnClickListener(this)
    }

}
