package com.jpmorgan.typicode.utils

import com.jpmorgan.typicode.pojos.Album

object TestUtils {

    val albums: Array<Album>
        get() {

            val album = Album()
            album.title = "Dr Who"
            album.userId = 1000000
            album.id = 21
            return arrayOf(album)
        }
}
