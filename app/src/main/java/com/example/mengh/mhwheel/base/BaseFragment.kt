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
        if (fastClick())
            widgetClick(v)
    }


    /**
     * 防止快速点击
     *
     * @return
     */
    private fun fastClick(): Boolean {
        var lastClick: Long = 0
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false
        }
        lastClick = System.currentTimeMillis()
        return true
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
