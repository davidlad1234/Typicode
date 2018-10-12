package com.jpmorgan.typicode.utils

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jpmorgan.typecode.R
import com.jpmorgan.typicode.activities.ActivityCallback
import com.jpmorgan.typicode.pojos.Album


class AlbumRecyclerViewAdapter(private val activityCallback: ActivityCallback,
                               private val albums: Array<Album>?) : RecyclerView.Adapter<AlbumViewHolder>() {

    init {

        Log.d(TAG, "Initialised recycler view with albums: ")
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): AlbumViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.album_list_content, viewGroup, false)
        Log.d(TAG, "creating view holder..................")
        return AlbumViewHolder(activityCallback, view, albums!!)

    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albums!![position]
        Log.d(TAG, "Binding view holder . .....$album")

        holder.contentView!!.tag = position
        holder.titleView!!.text = album.title
        holder.idView!!.text = album.id.toString()
        holder.userIdView!!.text = album.userId.toString()
        Log.d(TAG, "Bound view holder ...success..")

    }


    override fun getItemCount(): Int {
        return albums?.size ?: 0
    }

    companion object {

        val TAG = AlbumRecyclerViewAdapter::class.java.getSimpleName()
    }

}
