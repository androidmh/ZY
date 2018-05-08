package com.example.mengh.mhwheel.news

import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_BACK
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.BaseActivity
import com.example.mengh.mhwheel.base.ProjectConstant.Companion.KEY_NEWS
import kotlinx.android.synthetic.main.activity_news.*


class NewsActivity : BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_news

    override fun initParms(parms: Bundle?) {
        val str: String = parms!![KEY_NEWS] as String
        initWeb(str)
    }

    private fun initWeb(str: String) {
        web_news.canGoBack()
        web_news.goBack()
        val webSettings = web_news.settings
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.javaScriptEnabled = true
        //支持插件
//        webGoods.getSettings().setPluginState(WebSettings.PluginState.ON);

        //设置自适应屏幕，两者合用
        webSettings.useWideViewPort = true //将图片调整到适合webview的大小
        webSettings.loadWithOverviewMode = true // 缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true) //支持缩放，默认为true。是下面那个的前提。
        webSettings.builtInZoomControls = false //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.displayZoomControls = false //隐藏原生的缩放控件

        //其他细节操作
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE //关闭webview中缓存
        webSettings.allowFileAccess = true //设置可以访问文件
        webSettings.javaScriptCanOpenWindowsAutomatically = true //支持通过JS打开新窗口
        webSettings.loadsImagesAutomatically = true //支持自动加载图片
        webSettings.defaultTextEncodingName = "utf-8"//设置编码格式
        web_news.loadUrl(str)
        web_news.webChromeClient = (object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                // TODO 自动生成的方法存根

                if (newProgress == 100) {
                    pb_web.visibility = View.GONE//加载完网页进度条消失
                } else {
                    pb_web.visibility = View.VISIBLE//开始加载网页时显示进度条
                    pb_web.progress = newProgress//设置进度值
                }
            }
        })
        web_news.webViewClient = (object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        })
    }

    override fun initView(view: View) {

    }

    override fun setListener() {
    }

    override fun widgetClick(v: View) {
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KEYCODE_BACK && web_news.canGoBack()) {
            web_news.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
