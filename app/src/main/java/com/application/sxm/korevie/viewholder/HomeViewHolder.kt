package com.application.sxm.korevie.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.application.sxm.korevie.R
import com.facebook.drawee.view.SimpleDraweeView

/**
 * TITLE
 * Created by shixiaoming on 2019-07-15.
 */
class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val text: TextView

    val cover: SimpleDraweeView

    init {
        this.text = itemView.findViewById(R.id.content)
        this.cover = itemView.findViewById(R.id.cover)
    }
}