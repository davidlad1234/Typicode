package com.jpmorgan.typicode.utils

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.ButterKnife
import butterknife.OnClick
import com.jpmorgan.typecode.R
import com.jpmorgan.typicode.activities.ActivityCallback
import com.jpmorgan.typicode.pojos.Album
import kotlinx.android.synthetic.main.album_list_content.view.*

class AlbumViewHolder internal constructor(private val activityCallback: ActivityCallback, view: View, private val albums: Array<Album>) : RecyclerView.ViewHolder(view) {

    internal var contentView: LinearLayout? = view.content_area
    internal var idView: TextView? = view.id_id
    internal var userIdView: TextView? = view.user_id
    internal var titleView: TextView? = view.user_id

    init {
        ButterKnife.bind(this, view)
        Log.d(TAG, "Initialised view holder")
    }

    @OnClick(R.id.content_area)
    fun onClickViews(view: View) {
        val position = view.tag as Int
        val album = albums[position]
        activityCallback.processCall(album)
    }

    companion object {
        val TAG = AlbumViewHolder::class.java.getSimpleName()
    }
}

