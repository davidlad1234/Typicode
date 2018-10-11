package com.jpmorgan.typicode.utils;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jpmorgan.typecode.R;
import com.jpmorgan.typicode.activities.ActivityCallback;
import com.jpmorgan.typicode.pojos.Album;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AlbumViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = AlbumViewHolder.class.getSimpleName();

    @BindView(R.id.content_area)
    public LinearLayout contentView;
    @BindView(R.id.id)
    TextView idView;

    @BindView(R.id.user_id)
    TextView userIdView;

    @BindView(R.id.title)
    TextView titleView;

    private Album[] albums;
    private ActivityCallback activityCallback;

    AlbumViewHolder(ActivityCallback activityCallback, View view, Album[] albums) {
        super(view);
        ButterKnife.bind(this, view);
        this.albums = albums;
        this.activityCallback = activityCallback;

        Log.d(TAG,"Initialised view holder");
    }

    @OnClick(R.id.content_area)
    public void onClickViews(View view) {
        int position = (int) view.getTag();
        Album album = albums[position];
        activityCallback.processCall(album);
    }
}

