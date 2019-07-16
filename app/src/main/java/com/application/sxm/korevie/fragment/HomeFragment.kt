package com.application.sxm.korevie.fragment

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.application.sxm.korevie.R
import com.application.sxm.korevie.model.GankFuLiModel
import com.application.sxm.korevie.model.MovieItemBean
import com.application.sxm.korevie.model.MovieListModel
import com.application.sxm.korevie.network.DoubanApiProvider
import com.application.sxm.korevie.network.GankApiProvider
import com.application.sxm.korevie.viewholder.HomeViewBinder
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.revie_fragment_home.*
import me.drakeet.multitype.MultiTypeAdapter

/**
 * 首页fragment
 * Created by shixiaoming on 2019-07-12.
 */
class HomeFragment: BaseFragment() {

    private lateinit var mAdapter: MultiTypeAdapter

    override fun getContentViewRes(): Int = R.layout.revie_fragment_home

    override fun initView() {
        val layoutmanager = GridLayoutManager(context, 2)
        recycler.layoutManager = layoutmanager
        mAdapter = MultiTypeAdapter()
        mAdapter.register(GankFuLiModel.FuLiItem::class.java, HomeViewBinder())
        recycler.adapter = mAdapter
    }

    override fun initData() {
        GankApiProvider.getInstance().fuli
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<GankFuLiModel> {

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(fuliModel: GankFuLiModel) {
                    onLoadSuccess(fuliModel)
                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {

                }

            })
    }
    private fun onLoadSuccess(fuliModel: GankFuLiModel?) {
        if (fuliModel != null && fuliModel.results != null && !fuliModel.results.isEmpty()) {
            mAdapter.setItems(fuliModel.results)
            mAdapter.notifyDataSetChanged()
        }
    }
}