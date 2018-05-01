package yuncha.dlz.com.yuncha.base

import android.app.Application
import android.content.Context
import com.vondear.rxtools.RxTool
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession
/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
class ApplicationEx : Application() {

    /**
     * Activity管理器
     */
    /**
     * 数据缓存区，用于数据的临时缓存
     */
    private val mHardCache: MutableMap<String, Any>? = null
    /**
     * 设备屏幕位深
     */
    /**
     * 获取屏幕像素密度
     *
     * @return Device Density 设备的像素密度
     */
    var deviceDensity: Float = 0.toFloat()
        private set
    /**
     * 设备屏幕宽度（单位像素）
     */
    /**
     * 获取当前设备的屏幕宽度
     *
     * @return Device Width 设备屏幕的宽度
     */
    var deviceWidth: Int = 0
        private set
    /**
     * 设备屏幕高度（单位像素）
     */
    /**
     * 获取当前屏幕的高度
     *
     * @return Device Height 设备屏幕的高度
     */
    var deviceHeight: Int = 0
        private set

    /** 当前用户  */


    override fun onCreate() {
        super.onCreate()
        application = this
        mApplication = this
        RxTool.init(this);
//        setDatabase()
    }






    private inner class SafeHostnameVerifier : HostnameVerifier {
        override fun verify(hostname: String, session: SSLSession): Boolean {
            //验证主机名是否匹配
            //return hostname.equals("server.jeasonlzy.com");
            return true
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    /**
     * initResolution:初始化屏幕信息. <br></br>
     * 初始化屏幕的宽度，高度以及像素密度.<br></br>
     * 宽高的单位都是像素，px不是dp.<br></br>
     */
    private fun initResolution() {
        val dm = resources.displayMetrics
        deviceWidth = dm.widthPixels
        deviceHeight = dm.heightPixels
        deviceDensity = dm.density
    }

    /**
     * 获取activity管理器
     *
     * @return CustomActivityManager
     */


    /**
     * 缓存数据内容
     *
     * @param key   键值
     * @param value 需要存储的数值
     */
    fun cache(key: String, value: Any) {
        mHardCache!![key] = value
    }

    /**
     * 获取缓存内容
     *
     * @param key 键值
     * @return Object
     */
    fun getCache(key: String): Any? {
        return mHardCache!![key]
    }

    /**
     * 移除缓存
     *
     * @param key 键值
     */
    fun removeCache(key: String) {
        mHardCache!!.remove(key)
    }

    /**
     * 清空系统缓存区
     */
    fun clearCache() {
        mHardCache!!.clear()
        Runtime.getRuntime().gc()
    }

    /**
     * 当系统内存不足时调用
     */
    override fun onLowMemory() {
        super.onLowMemory()
        Runtime.getRuntime().gc()// 通知Java虚拟机回收垃圾
    }

    /**
     * 程序终止时候调用
     */
    override fun onTerminate() {
        super.onTerminate()
    }

    companion object {

        private var mApplication: ApplicationEx? = null
        var application: ApplicationEx? = null
            private set
        /**
         * 单例方法
         *
         * @return ApplicationEx
         */
        val instance: ApplicationEx
            get() {
                if (mApplication == null) {
                    mApplication = ApplicationEx()
                }
                return mApplication as ApplicationEx
            }
    }


}
