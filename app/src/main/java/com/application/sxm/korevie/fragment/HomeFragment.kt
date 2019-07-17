package com.application.sxm.korevie.fragment

import android.support.v7.widget.GridLayoutManager
import android.util.Log
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
        mAdapter.register(MovieItemBean::class.java, HomeViewBinder())
        recycler.adapter = mAdapter
    }

    override fun initData() {
        DoubanApiProvider.getInstance().hotMovie
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<MovieListModel> {

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(list: MovieListModel) {
                    onLoadSuccess(list)
                }

                override fun onError(e: Throwable) {
                    Log.e("Network_Error", e.toString())
                }

                override fun onComplete() {

                }

            })
    }
    private fun onLoadSuccess(fuliModel: MovieListModel?) {
        if (fuliModel != null && fuliModel.subjects != null && !fuliModel.subjects.isEmpty()) {
            mAdapter.setItems(fuliModel.subjects)
            mAdapter.notifyDataSetChanged()
        }
    }
}