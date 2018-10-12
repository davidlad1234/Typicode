package com.jpmorgan.typicode.activities

import android.content.Context

import com.jpmorgan.typicode.pojos.Album

interface LocalCallback {
    val context: Context

    fun showAlbums(albums: Array<Album>)

    fun showErrorMessage(message: String)

}
