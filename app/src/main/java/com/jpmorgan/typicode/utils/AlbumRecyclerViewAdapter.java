package com.jpmorgan.typicode.utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jpmorgan.typecode.R;
import com.jpmorgan.typicode.activities.ActivityCallback;
import com.jpmorgan.typicode.pojos.Album;


public class AlbumRecyclerViewAdapter extends RecyclerView.Adapter<AlbumViewHolder> {

    public static final String TAG = AlbumRecyclerViewAdapter.class.getSimpleName();
    private final ActivityCallback activityCallback;
    private final Album[] albums;

    public AlbumRecyclerViewAdapter(ActivityCallback parent,
                                    Album[] albums) {
        this.activityCallback = parent;
        this.albums = albums;

        Log.d(TAG, "Initialised recycler view with albums: ");
    }


    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.album_list_content, viewGroup, false);
        Log.d(TAG, "creating view holder..................");
        return new AlbumViewHolder(activityCallback, view, albums);

    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albums[position];
        Log.d(TAG, "Binding view holder . ....." + album);
        if (album != null) {

            holder.contentView.setTag(position);
            holder.titleView.setText(album.getTitle());
            holder.idView.setText(String.valueOf(album.getId()));
            holder.userIdView.setText(String.valueOf(album.getUserId()));
            Log.d(TAG, "Bound view holder ...success..");

        }

    }


    @Override
    public int getItemCount() {
        return albums != null ? albums.length : 0;
    }

}
