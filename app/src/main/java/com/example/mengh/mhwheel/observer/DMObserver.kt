package com.example.mengh.test.test

import android.content.Context
import android.util.Log

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
class DMObserver<T>(private val context: Context, private val listener: ObserverOnNextListener<T>) : Observer<T> {

    override fun onSubscribe(d: Disposable) {
        Log.d(TAG, "onSubscribe: ")
        //添加业务处理
    }

    override fun onNext(t: T) {
        listener.onNext(t)
    }

    override fun onError(e: Throwable) {
        Log.e(TAG, "onError: ", e)
        //添加业务处理
    }

    override fun onComplete() {
        Log.d(TAG, "onComplete: ")
        //添加业务处理
    }

    companion object {
        private val TAG = "MyObserver"
    }
}