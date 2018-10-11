package com.jpmorgan.typicode.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jpmorgan.typecode.R;
import com.jpmorgan.typicode.pojos.Album;
import com.jpmorgan.typicode.presenters.AlbumListPresenter;
import com.jpmorgan.typicode.utils.AlbumRecyclerViewAdapter;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * An activity representing a list of ResponseModel. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of ResponseModel
 */
public class AlbumListActivity extends AlbumActivity implements LocalCallback,ActivityCallback {

    private static final String TAG = AlbumListActivity.class.getClass().getSimpleName();

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean isTwoPane;


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.album_detail_container)
    @Nullable
    LinearLayout detailContainer;

    @BindView(R.id.album_list)
    RecyclerView recyclerView;

    //@TODO inject using Dagger
    AlbumListPresenter albumListPresenter;

    protected Toast toast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);
        ButterKnife.bind(this);
        albumListPresenter = new AlbumListPresenter();
        setSupportActionBar(toolbar);
        setTitles();

        if (detailContainer != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            isTwoPane = true;
        }
        assert recyclerView != null;
        //
    }

    private void setTitles() {
        setTitle(R.string.album_list_test);
        toolbar.setTitle(getTitle());
    }

    @Override
    public void onStart() {
        super.onStart();
        albumListPresenter.fetchPhotos(new WeakReference<LocalCallback>(this));
    }

    @OnClick(R.id.fab)
    public void onClickFab(View view) {
        Snackbar.make(view, "Album list display ", Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    public void showAlbums(Album[] albums) {

        recyclerView.setAdapter(new AlbumRecyclerViewAdapter(AlbumListActivity.this, albums));


    }

    @Override
    public void showErrorMessage(String message) {
        toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void showErrorMessage(int server_error) {
        toast = Toast.makeText(this, getString(R.string.data_error), Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onStop() {
        super.onStop();
        albumListPresenter.onStop();
    }

    @Override
    public void processCall(Album album) {
        //does nothing in this implementation ..provides ability to introspect or use single album data
        Log.d(TAG,"Received album.....");
    }
}
