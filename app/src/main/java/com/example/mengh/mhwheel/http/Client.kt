package com.example.mengh.test

import com.example.mengh.mhwheel.base.Constant
import com.example.mengh.mhwheel.http.BasicParamsInterceptor
import com.example.mengh.mhwheel.utils.Md5Utils
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
class Client {
    /**
     * 这里其实应该用单例，而kotlin中的单例也十分简单，但是本项目的接口设计是需要添加全局
     * 可变的公共参数，所以为了每次都会添加动态的时间戳，这里不推荐使用单例，否则会导致接口
     * 的鉴权过期，所以使用伴生对象来实现类似Java中的静态方法
     */
    companion object {
        fun getClient(type: Int): ClientService {
            //接口类
            var apiService: ClientService
            var baseUrl = ""
            if (type == 1) {
                baseUrl = "https://api.xinwen.cn/news/"
            } else if (type == 2) {
                baseUrl = "http://image.baidu.com/channel/"
            } else if (type == 3) {
                baseUrl = "http://baobab.kaiyanapp.com/api/"
            }
            //时间戳
            var time = System.currentTimeMillis().toString()
            //接口需要的动态MD5签名
            var sign = Md5Utils.md5(Constant.SECRET_KEY + time + Constant.ACCESS_KEY)
            //okhttp3的拦截器，配合retrofit来实现动态添加全局公共参数 ps：添加header同样适用
            var basicParamsInterceptor = BasicParamsInterceptor.Builder()
                    .addQueryParam("access_key", Constant.ACCESS_KEY)
                    .addQueryParam("timestamp", time)
                    .addQueryParam("signature", sign)
                    .build()
            val client = OkHttpClient.Builder()
                    .addInterceptor(basicParamsInterceptor)
                    .build()
            //retrofit的请求体
            val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())//请求的结果转为实体类
                    //适配RxJava2.0,RxJava1.x则为RxJavaCallAdapterFactory.create()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build()
            apiService = retrofit.create(ClientService::class.java)
            return apiService
        }
    }
}
