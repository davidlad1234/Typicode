package com.jpmorgan.typicode.activities

import com.jpmorgan.typicode.pojos.Album

interface ActivityCallback {

    fun processCall(album: Album)
}
