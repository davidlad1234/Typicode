package com.jpmorgan.typicode.activities;

import com.jpmorgan.typicode.pojos.Album;

public interface ActivityCallback {

    void processCall(Album album);
}
