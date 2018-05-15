package com.example.mengh.mhwheel.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
abstract class BaseFragment : Fragment(), View.OnClickListener {
    private var mContextView: View? = null
    protected abstract val layoutId: Int
    var mactivity: BaseActivity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mactivity = activity as BaseActivity?
        mContextView = inflater.inflate(layoutId, container, false)
        return mContextView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        doBusiness(activity)
    }
    /**
     * 业务操作
     *
     * @param mContext
     */
    abstract fun doBusiness(mContext: Context?)

    /** View点击  */
    abstract fun widgetClick(v: View)

    override fun onClick(v: View) {
        if (!isFastClick(1000)) {
            widgetClick(v)
        } else {
            mactivity!!.showToast("请勿重复点击", 4)
            return
        }
    }


    /**
     * 防止快速点击
     *
     * @return
     */
    private var lastClickTime: Long = 0

    private fun isFastClick(millisecond: Int): Boolean {
        val curClickTime = System.currentTimeMillis()
        val interval = curClickTime - lastClickTime

        if (0 < interval && interval < millisecond) {
            // 超过点击间隔后再将lastClickTime重置为当前点击时间
            return true
        }
        lastClickTime = curClickTime
        return false
    }

    /**
     * 页面跳转
     *
     * @param clz
     */
    protected fun startActivityf(clz: Class<*>) {
        startActivity(Intent(mactivity, clz))
    }

    /**
     * 携带数据的页面跳转
     *
     * @param clz
     * @param bundle
     */
    protected fun startActivityf(clz: Class<*>, bundle: Bundle?) {
        val intent = Intent()
        intent.setClass(mactivity, clz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }
}
