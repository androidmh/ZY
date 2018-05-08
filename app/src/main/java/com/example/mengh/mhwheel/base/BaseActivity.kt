package com.example.mengh.mhwheel.base

import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import com.example.mengh.mhwheel.utils.ActivityManagerUtils
import com.example.mengh.mhwheel.utils.DialogUtil
import com.vondear.rxtools.view.RxToast

/**
 * Created by HDM on 2017/12/13.
 * E-mail menghedianmo@163.com
 * author HDM
 */

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {

    var mContext: BaseActivity? = null

    /**
     * 是否沉浸状态栏
     */
    private var isSetStatusBar = false
    /**
     * 是否允许全屏
     */
    private var mAllowFullScreen = false
    /**
     * 全局ProgressDialog
     */
    private var pd: ProgressDialog? = null
    /**
     * 是否禁止旋转屏幕
     */
    private var isAllowScreenRoate = false
    /**
     * 当前Activity渲染的视图View
     */
    private var mContextView: View? = null
    /**
     * 日志输出标志
     */
    private val TAG = this.javaClass.simpleName

    protected var layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        Log.d(TAG, "BaseActivity-->onCreate()")
        val bundle = intent.extras
        mContextView = LayoutInflater.from(this)
                .inflate(layoutId, null)
        if (mAllowFullScreen) {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
        }
        if (isSetStatusBar) {
            steepStatusBar()
        }
        setContentView(mContextView)
        if (!isAllowScreenRoate) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        initParms(bundle)
        initView(this.mContextView!!)
        setListener()
        //为每一个Activity添加管理
        ActivityManagerUtils.getInstance().addActivity(this@BaseActivity)

    }

    /**
     * 关闭指定页面
     *
     * @param cls 指定界面
     */
    protected fun finishThinActivity(cls: Class<*>) {
        ActivityManagerUtils.getInstance().finishActivityclass(cls)
    }

    /**
     * 是否处理返回按钮点击事迹
     *
     * @return 是否处理
     */
    protected fun handleNvgOnClickListener(): Boolean {
        return false
    }

    /**
     * 沉浸状态栏
     */
    private fun steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            window.addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //            // 透明导航栏
            //            getWindow().addFlags(
            //                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 初始化参数
     *
     * @param parms
     */
    protected abstract fun initParms(parms: Bundle?)


    /**
     * 绑定布局
     *
     * @return
     */
    protected abstract val layoutId: Int
    /**
     * 初始化控件
     *
     * @param view
     */
    protected abstract fun initView(view: View)


    /**
     * 设置监听
     */
    protected abstract fun setListener()

    override fun onClick(v: View) {
        widgetClick(v)
    }

    /**
     * View点击
     */
    protected abstract fun widgetClick(v: View)

    /**
     * 页面跳转
     *
     * @param clz
     */
    protected fun startsActivity(clz: Class<*>) {
        startActivity(Intent(this@BaseActivity, clz))
    }

    /**
     * 携带数据的页面跳转
     *
     * @param clz
     * @param bundle
     */
    protected fun startActivity(clz: Class<*>, bundle: Bundle?) {
        val intent = Intent()
        intent.setClass(this, clz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    /**
     * 含有Bundle通过Class打开编辑界面
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    fun startActivityForResult(cls: Class<*>, bundle: Bundle?,
                               requestCode: Int) {
        val intent = Intent()
        intent.setClass(this, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, requestCode)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }

    /**
     * 简化Toast
     *
     * @param msg
     */
    open fun showToast(msg: String, type: Int) {
        when (type) {
        //错误
            1 -> RxToast.error(msg)
        //成功
            2 -> RxToast.success(msg)
        //信息
            3 -> RxToast.info(msg)
        //警告
            4 -> RxToast.warning(msg)
        //普通
            5 -> RxToast.normal(msg)
        }
    }

    protected fun showToast(msg: Int, type: Int) {
        val string = getString(msg)
        when (type) {
            1 -> RxToast.error(string)
            2 -> RxToast.success(string)
            3 -> RxToast.info(string)
            4 -> RxToast.warning(string)
            5 -> RxToast.normal(string)
        }
    }

    /**
     * 是否允许屏幕旋转
     *
     * @param isAllowScreenRoate
     */
    fun setScreenRoate(isAllowScreenRoate: Boolean) {
        this.isAllowScreenRoate = isAllowScreenRoate
    }


    /**
     * 是否允许全屏
     *
     * @param allowFullScreen
     */
    fun setAllowFullScreen(allowFullScreen: Boolean) {
        this.mAllowFullScreen = allowFullScreen
    }

    /**
     * 是否设置沉浸状态栏
     *
     * @param isSetStatusBar
     */
    fun setSteepStatusBar(isSetStatusBar: Boolean) {
        this.isSetStatusBar = isSetStatusBar
    }

    protected fun showpdDialog(msg: String) {
        pd = DialogUtil.getProgressDialog(this, msg)
        pd!!.show()
    }

    protected fun hideDialog() {
        if (pd != null) {
            pd!!.dismiss()
        }
    }
}






