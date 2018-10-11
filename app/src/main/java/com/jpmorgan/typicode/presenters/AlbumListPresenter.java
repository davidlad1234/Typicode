package com.jpmorgan.typicode.presenters;

import android.support.annotation.Nullable;
import android.util.Log;

import com.jpmorgan.typecode.R;
import com.jpmorgan.typicode.activities.LocalCallback;
import com.jpmorgan.typicode.pojos.Album;
import com.jpmorgan.typicode.remote.FMDataService;
import com.jpmorgan.typicode.remote.RetrofitClient;

import java.lang.ref.WeakReference;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class AlbumListPresenter implements ListPresenter {


    private static final String TAG = AlbumListPresenter.class.getSimpleName();
    public boolean isStopped;
    private DisposableSingleObserver<Album[]> disposableSingleObserver;


    /**
     * Makes the http request and sends the Results to the adapter.
     */
    public void fetchPhotos(final WeakReference<LocalCallback> weakReference) {
        Retrofit retroClient = RetrofitClient.getRetrofitInstance();
        FMDataService dataService = retroClient.create(FMDataService.class);

        disposableSingleObserver = dataService.getAlbums()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Album[]>() {

                    @Override
                    public void onSuccess(Album[] albums) {
                        LocalCallback callback = getLocalCallback(weakReference);
                        if (callback != null) {

                            if (albums != null) {

                                Log.d(TAG, "Received from server: " + albums);
                                callback.showAlbums(albums);
                            }

                        } else {
                            Log.d(TAG, "Error getting response ");
                            callback.showErrorMessage(R.string.server_error);
                        }

                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "Error: " + e.getMessage());
                        LocalCallback callback = getLocalCallback(weakReference);
                        if (callback != null) {
                            callback.showErrorMessage(e.getMessage());
                        }
                    }
                });
    }

    private LocalCallback getLocalCallback(WeakReference<LocalCallback> weakReference) {
        return weakReference.get() != null ? weakReference.get() : null;
    }

    @Override
    public void onStop() {
        if (disposableSingleObserver != null && !disposableSingleObserver.isDisposed()) {
            disposableSingleObserver.dispose();
        }
        isStopped = true;
    }

}