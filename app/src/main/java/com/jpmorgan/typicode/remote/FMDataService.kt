package com.jpmorgan.typicode.remote

import com.jpmorgan.typicode.pojos.Album
import io.reactivex.Single
import retrofit2.http.GET

interface FMDataService {
    @get:GET("/albums")
    val albums: Single<Array<Album>>

}
