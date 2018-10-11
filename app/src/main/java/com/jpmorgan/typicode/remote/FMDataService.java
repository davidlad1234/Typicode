package com.jpmorgan.typicode.remote;

import com.jpmorgan.typicode.pojos.Album;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FMDataService {
    @GET("/albums")
    Single<Album[]> getAlbums();

}
