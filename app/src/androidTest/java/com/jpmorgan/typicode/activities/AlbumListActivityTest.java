package com.jpmorgan.typicode.activities;

import android.content.Context;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;

import com.jpmorgan.typicode.utils.TestUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.logging.Handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AlbumListActivityTest {

    AlbumListActivity albumListActivity = null;

    @Rule
    public ActivityTestRule<AlbumListActivity> mActivity = new ActivityTestRule(AlbumListActivity.class);

    @Before
    public void setUp() throws Exception {
        albumListActivity = mActivity.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        albumListActivity = null;
    }

    @Test
    public void onCreate() {
        assertNotNull(albumListActivity);
        assertNotNull(albumListActivity.toolbar);
        assertNotNull(albumListActivity.fab);
        assertNotNull(albumListActivity.albumListPresenter);
    }


    @Test
    public void getContext() {
        Object obj = albumListActivity.getContext();
        assertTrue(obj instanceof Context);
    }

    @Test
    @UiThreadTest
    public void showAlbums() {

        albumListActivity.showAlbums(TestUtils.getAlbums());
        assertTrue(albumListActivity.recyclerView.getAdapter().getItemCount() == 1);
    }

    @Test
    public void onClickFab() {
        boolean b = albumListActivity.fab.callOnClick();
        assertTrue(b);
    }

    @Test
    @UiThreadTest
    public void onStop() {
        assertEquals(2, albumListActivity.currentStatus);

        albumListActivity.finish();


    }


    @Test
    @UiThreadTest
    public void setAppBarTitle() {
        assertEquals("Album List Test", albumListActivity.getTitle());
    }
}
