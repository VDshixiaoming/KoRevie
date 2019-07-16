package com.application.sxm.korevie.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.application.sxm.korevie.R
import com.application.sxm.korevie.model.GankFuLiModel
import me.drakeet.multitype.ItemViewBinder

/**
 * 首页adapter绑定数据
 * Created by shixiaoming on 2019-07-15.
 */
class HomeViewBinder : ItemViewBinder<GankFuLiModel.FuLiItem, HomeViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): HomeViewHolder {
        var root = inflater.inflate(R.layout.revie_home_list_item, parent, false)
        return HomeViewHolder(root)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, item: GankFuLiModel.FuLiItem) {
        holder.text.text = item.who
        holder.cover.setImageURI(item.url)
    }
}
