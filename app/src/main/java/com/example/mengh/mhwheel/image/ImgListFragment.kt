package com.example.mengh.mhwheel.image

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.mengh.mhwheel.R
import com.example.mengh.mhwheel.base.Constant
import com.example.mengh.mhwheel.base.LazyLoadFragment
import com.example.mengh.mhwheel.image.adapter.ImageListAdapter
import com.example.mengh.mhwheel.image.bean.ImageListBean
import com.example.mengh.mhwheel.image.presenter.ImgListContract
import com.example.mengh.mhwheel.image.presenter.ImgListPresenter
import com.example.mengh.mhwheel.image.view.ImgDialogFragment
import kotlinx.android.synthetic.main.fragment_imglist.*


class ImgListFragment : LazyLoadFragment(),ImgListContract.view{
    //presenter
    lateinit var imgListPresenter: ImgListPresenter
    //页码
    var page: Int = 0
    //一次加载几条数据 ps:由于接口问题，每次返回数据会多一条空对象，下面会做处理
    var pagnum: Int = 16
    //标签
    lateinit var tags: String
    //adapter
    lateinit var adapter: ImageListAdapter

    override fun setContentView(): Int {
        return R.layout.fragment_imglist
    }

    override fun lazyLoad() {
        tags = arguments!!.getString(Constant.TAB_KEY)
        imgListPresenter = ImgListPresenter(this, mactivity)
        imgListPresenter.getImgList(page, pagnum, tags)
    }

    override fun showData(imglist: MutableList<ImageListBean.DataBean>) {
        //这里坐立上述多一条空对象的处理
        var list = imglist
        list.removeAt(pagnum)
        setRecy(list)
    }

    private fun setRecy(imglist: MutableList<ImageListBean.DataBean>) {
        adapter = ImageListAdapter(R.layout.item_imglist, imglist)
        val layoutManager = GridLayoutManager(mactivity, 2)
        rv_img.layoutManager = layoutManager
        rv_img.adapter = adapter;
        //item点击事件
        adapter!!.setOnItemClickListener(BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            ImgDialogFragment(imglist[position].image_url,imglist[position].thumbnail_url).show(fragmentManager, "imgdialog")
        })
        //下拉刷新
        sl_img.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            imgListPresenter.getImgList(page, pagnum, tags)
        })
        //上拉加载
        adapter.setOnLoadMoreListener(BaseQuickAdapter.RequestLoadMoreListener {
            page++
            imgListPresenter.loadMoreList(page, pagnum, tags)

        }, rv_img)

    }

    override fun showfailemsg(str: String) {
        mactivity.showToast(str, 1)
    }

    override fun getLists(isshow: Boolean) {
        if (isshow) {
            sl_img.isRefreshing = true
        } else {
            sl_img.isRefreshing = false
        }
    }

    override fun showMoreList(imglist: MutableList<ImageListBean.DataBean>) {
        //判断如果数据不够便是到最后一页，没有更多数据了
        if (imglist.size < pagnum||imglist.size==0) {
            adapter.loadMoreEnd()
        } else {
            var list = imglist
            list.removeAt(pagnum)
            adapter.addData(list)
            adapter.loadMoreComplete();
        }
    }
}