package com.jpmorgan.typicode.utils;

import android.support.test.rule.ActivityTestRule;

import com.jpmorgan.typicode.activities.AlbumListActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

//NOT ENOUGH TIME TO FINISH TEST
public class AlbumRecyclerViewAdapterTest {

    AlbumListActivity albumListActivity = null;

    AlbumRecyclerViewAdapter albumRecyclerViewAdapter = null;

    @Rule
    public ActivityTestRule<AlbumListActivity> mActivity = new ActivityTestRule(AlbumListActivity.class);

    @Before
    public void setUp() throws Exception {
        albumListActivity = mActivity.getActivity();
        albumRecyclerViewAdapter = new AlbumRecyclerViewAdapter(albumListActivity, TestUtils.getAlbums());
    }


    @Test
    public void onCreateViewHolder() {

    }

    @Test
    public void onBindViewHolder() {
    }

    @Test
    public void getItemCount() {
    }
}