package com.example.mengh.mhwheel.index

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.BaseFragment
import com.example.mengh.mhwheel.index.adapter.IndexAdapter
import com.example.mengh.mhwheel.index.bean.IndexBean
import com.example.mengh.mhwheel.index.item.IndexItem
import kotlinx.android.synthetic.main.fragment_index.*


/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
class IndexFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_index


    override fun doBusiness(mContext: Context?) {
        setRecy()
    }

    private fun setRecy() {
        var data: MutableList<IndexItem> = ArrayList()
        for (i in 0..9) {
            if (i == 0) {
                data.add(IndexItem(IndexItem.IMG, null))
            } else {
                data.add(IndexItem(IndexItem.LAYOUT, IndexBean(i, "$i", "条目 $i")))
            }
        }
        val adapter = IndexAdapter(data)
        val layoutManager = LinearLayoutManager(mactivity)
        rv_index.layoutManager = layoutManager
        rv_index.adapter = adapter
    }

    override fun widgetClick(v: View) {
    }

}