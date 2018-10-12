package com.jpmorgan.typicode.activities

import android.support.test.annotation.UiThreadTest
import android.support.test.rule.ActivityTestRule
import com.jpmorgan.typicode.utils.TestUtils
import kotlinx.android.synthetic.main.activity_album_list.*
import kotlinx.android.synthetic.main.album_list.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AlbumListActivityTest {

    private var albumListActivity: AlbumListActivity? = null

    @Rule
    var mActivity: ActivityTestRule<AlbumListActivity> = ActivityTestRule(AlbumListActivity::class.java)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        albumListActivity = mActivity.activity
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        albumListActivity = null
    }

    @Test
    fun onCreate() {
        assertNotNull(albumListActivity)
        assertNotNull(albumListActivity!!.toolbar)
        assertNotNull(albumListActivity!!.fab)
        assertNotNull(albumListActivity!!.albumListPresenter)
    }


    @Test
    fun getContext() {
        val obj = albumListActivity!!.context
        assertNotNull(obj)
    }

    @Test
    @UiThreadTest
    fun showAlbums() {

        albumListActivity!!.showAlbums(TestUtils.albums)
        assertTrue(albumListActivity!!.album_list.adapter?.getItemCount() == 1)
    }

    @Test
    fun onClickFab() {
        val b = albumListActivity!!.fab.callOnClick()
        assertTrue(b)
    }

    @Test
    @UiThreadTest
    fun onStop() {
        assertEquals(2, albumListActivity!!.currentStatus.toLong())

        albumListActivity!!.finish()


    }


    @Test
    @UiThreadTest
    fun setAppBarTitle() {
        assertEquals("Album List Test", albumListActivity!!.title)
    }
}
