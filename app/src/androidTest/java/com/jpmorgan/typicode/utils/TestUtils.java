package com.jpmorgan.typicode.utils;

import com.jpmorgan.typicode.pojos.Album;

public class TestUtils {

    public static Album[] getAlbums() {

        Album album = new Album();
        album.setTitle("Dr Who");
        album.setUserId(1000000);
        album.setId(21);
        return new Album[]{album};
    }
}
