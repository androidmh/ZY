package com.example.mengh.test

import com.example.mengh.mhwheel.image.bean.ImageListBean
import com.example.mengh.mhwheel.news.bean.NewsBean
import com.example.mengh.mhwheel.videos.bean.VideoListBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
interface ClientService {
    //获取新闻
    @GET("all")
    fun getTopNews(): Observable<NewsBean>

    //搜索新闻
    @GET("search")
    fun getSearchNews(@Query("q") search: String): Observable<NewsBean>

    //获取图片集合
    @GET("listjson")
    fun getImgList(@Query("pn") page: Int,
                   @Query("rn") pagenum: Int,
                   @Query("tag1") tag: String): Observable<ImageListBean>

    //获取视频集合
    @GET("v4/discovery/hot")
    fun getVideoList(@Query("pn") page: Int): Observable<VideoListBean>

    //获取更多视频
    @GET
    fun getMoreVideoList(@Url url:String): Observable<VideoListBean>

    //获取搜索视频集合
    @GET("/api/v1/search")
    fun search(@Query("query") query: String,
               @Query("start") start: Int,
               @Query("num") num: Int): Observable<VideoListBean>
}
