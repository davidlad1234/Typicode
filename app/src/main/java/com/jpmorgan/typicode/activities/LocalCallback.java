package com.jpmorgan.typicode.activities;

import android.content.Context;

import com.jpmorgan.typicode.pojos.Album;
public interface LocalCallback {
    Context getContext();

    void showAlbums(Album[] albums);

    void showErrorMessage(String message);

    void showErrorMessage(int server_error);
}
