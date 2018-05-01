package com.example.mengh.mhwheel.http

import android.text.TextUtils

import java.io.IOException
import java.util.ArrayList
import java.util.HashMap

import okhttp3.FormBody
import okhttp3.Headers
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import okio.Buffer


/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
class BasicParamsInterceptor private constructor() : Interceptor {

    internal var queryParamsMap: MutableMap<String, String> = HashMap()
    internal var paramsMap: MutableMap<String, String>? = HashMap()
    internal var headerParamsMap: MutableMap<String, String> = HashMap()
    internal var headerLinesList: MutableList<String> = ArrayList()

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        var request: Request? = chain.request()
        val requestBuilder = request!!.newBuilder()

        // process header params inject
        val headerBuilder = request.headers().newBuilder()
        if (headerParamsMap.size > 0) {
            val iterator = headerParamsMap.entries.iterator()
            while (iterator.hasNext()) {
                val entry = iterator.next() as java.util.Map.Entry<*, *>
                headerBuilder.add(entry.key as String, entry.value as String)
            }
        }

        if (headerLinesList.size > 0) {
            for (line in headerLinesList) {
                headerBuilder.add(line)
            }
            requestBuilder.headers(headerBuilder.build())
        }
        // process header params end


        // process queryParams inject whatever it's GET or POST
        if (queryParamsMap.size > 0) {
            request = injectParamsIntoUrl(request.url().newBuilder(), requestBuilder, queryParamsMap)
        }

        // process post body inject
        if (paramsMap != null && paramsMap!!.size > 0 && request!!.method() == "POST") {
            if (request.body() is FormBody) {
                val newFormBodyBuilder = FormBody.Builder()
                if (paramsMap!!.size > 0) {
                    val iterator = paramsMap!!.entries.iterator()
                    while (iterator.hasNext()) {
                        val entry = iterator.next() as java.util.Map.Entry<*, *>
                        newFormBodyBuilder.add(entry.key as String, entry.value as String)
                    }
                }

                val oldFormBody = request.body() as FormBody?
                val paramSize = oldFormBody!!.size()
                if (paramSize > 0) {
                    for (i in 0 until paramSize) {
                        newFormBodyBuilder.add(oldFormBody.name(i), oldFormBody.value(i))
                    }
                }

                requestBuilder.post(newFormBodyBuilder.build())
                request = requestBuilder.build()
            } else if (request.body() is MultipartBody) {
                val multipartBuilder = MultipartBody.Builder().setType(MultipartBody.FORM)

                val iterator = paramsMap!!.entries.iterator()
                while (iterator.hasNext()) {
                    val entry = iterator.next() as java.util.Map.Entry<*, *>
                    multipartBuilder.addFormDataPart(entry.key as String, entry.value as String)
                }

                val oldParts = (request.body() as MultipartBody).parts()
                if (oldParts != null && oldParts.size > 0) {
                    for (part in oldParts) {
                        multipartBuilder.addPart(part)
                    }
                }

                requestBuilder.post(multipartBuilder.build())
                request = requestBuilder.build()
            }

        }
        return chain.proceed(request!!)
    }

    private fun canInjectIntoBody(request: Request?): Boolean {
        if (request == null) {
            return false
        }
        if (!TextUtils.equals(request.method(), "POST")) {
            return false
        }
        val body = request.body() ?: return false
        val mediaType = body.contentType() ?: return false
        return if (!TextUtils.equals(mediaType.subtype(), "x-www-form-urlencoded")) {
            false
        } else true
    }

    // func to inject params into url
    private fun injectParamsIntoUrl(httpUrlBuilder: HttpUrl.Builder, requestBuilder: Request.Builder, paramsMap: Map<String, String>): Request? {
        if (paramsMap.size > 0) {
            val iterator = paramsMap.entries.iterator()
            while (iterator.hasNext()) {
                val entry = iterator.next() as java.util.Map.Entry<*, *>
                httpUrlBuilder.addQueryParameter(entry.key as String, entry.value as String)
            }
            requestBuilder.url(httpUrlBuilder.build())
            return requestBuilder.build()
        }

        return null
    }

    private fun bodyToString(request: RequestBody?): String {
        try {
            val buffer = Buffer()
            if (request != null)
                request.writeTo(buffer)
            else
                return ""
            return buffer.readUtf8()
        } catch (e: IOException) {
            return "did not work"
        }

    }

    class Builder {

        internal var interceptor: BasicParamsInterceptor

        init {
            interceptor = BasicParamsInterceptor()
        }

        fun addParam(key: String, value: String): Builder {
            interceptor.paramsMap!![key] = value
            return this
        }

        fun addParamsMap(paramsMap: Map<String, String>): Builder {
            interceptor.paramsMap!!.putAll(paramsMap)
            return this
        }

        fun addHeaderParam(key: String, value: String): Builder {
            interceptor.headerParamsMap[key] = value
            return this
        }

        fun addHeaderParamsMap(headerParamsMap: Map<String, String>): Builder {
            interceptor.headerParamsMap.putAll(headerParamsMap)
            return this
        }

        fun addHeaderLine(headerLine: String): Builder {
            val index = headerLine.indexOf(":")
            if (index == -1) {
                throw IllegalArgumentException("Unexpected header: $headerLine")
            }
            interceptor.headerLinesList.add(headerLine)
            return this
        }

        fun addHeaderLinesList(headerLinesList: List<String>): Builder {
            for (headerLine in headerLinesList) {
                val index = headerLine.indexOf(":")
                if (index == -1) {
                    throw IllegalArgumentException("Unexpected header: $headerLine")
                }
                interceptor.headerLinesList.add(headerLine)
            }
            return this
        }

        fun addQueryParam(key: String, value: String): Builder {
            interceptor.queryParamsMap[key] = value
            return this
        }

        fun addQueryParamsMap(queryParamsMap: Map<String, String>): Builder {
            interceptor.queryParamsMap.putAll(queryParamsMap)
            return this
        }

        fun build(): BasicParamsInterceptor {
            return interceptor
        }

    }
}
