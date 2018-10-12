package com.jpmorgan.typicode.utils

import android.support.test.rule.ActivityTestRule

import com.jpmorgan.typicode.activities.AlbumListActivity

import org.junit.Before
import org.junit.Rule
import org.junit.Test

//NOT ENOUGH TIME TO FINISH TEST
class AlbumRecyclerViewAdapterTest {

    internal var albumListActivity: AlbumListActivity? = null

    internal var albumRecyclerViewAdapter: AlbumRecyclerViewAdapter? = null

    @Rule
    var mActivity: ActivityTestRule<AlbumListActivity> = ActivityTestRule(AlbumListActivity::class.java)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        albumListActivity = mActivity.activity
        albumRecyclerViewAdapter = AlbumRecyclerViewAdapter(albumListActivity!!, TestUtils.albums)
    }


    @Test
    fun onCreateViewHolder() {

    }

    @Test
    fun onBindViewHolder() {
    }

    @Test
    fun getItemCount() {
    }
}