package com.jpmorgan.typicode.presenters

import android.util.Log
import com.jpmorgan.typicode.activities.LocalCallback
import com.jpmorgan.typicode.pojos.Album
import com.jpmorgan.typicode.remote.FMDataService
import com.jpmorgan.typicode.remote.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.lang.ref.WeakReference
import java.util.*

class AlbumListPresenter : ListPresenter {
    private var isStopped: Boolean = false
    private var disposableSingleObserver: DisposableSingleObserver<Array<Album>>? = null


    /**
     * Makes the http request and sends the Results to the adapter.
     */
    fun fetchPhotos(weakReference: WeakReference<LocalCallback>) {
        val retroClient = RetrofitClient.retrofitInstance
        val dataService = retroClient.create(FMDataService::class.java)

        disposableSingleObserver = dataService.albums
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Array<Album>>() {

                    override fun onSuccess(albums: Array<Album>?) {
                        val callback = getLocalCallback(weakReference)
                        if (callback != null || albums != null) {
                            Log.d(TAG, "Received from server: $albums")
                            Arrays.sort(albums)
                            callback?.showAlbums(albums!!)
                        } else {
                            Log.d(TAG, "Error getting response  .... ")
                        }

                    }


                    override fun onError(e: Throwable) {
                        Log.d(TAG, "Error: " + e.message)
                        val callback = getLocalCallback(weakReference)
                        callback?.showErrorMessage(e.message!!)
                    }
                })
    }

    private fun getLocalCallback(weakReference: WeakReference<LocalCallback>): LocalCallback? {
        return if (weakReference.get() != null) {
            weakReference.get()
        } else null
    }

    override fun onStop() {
        if ((disposableSingleObserver?.isDisposed!!)) {
            disposableSingleObserver?.dispose()
        }
        isStopped = true
    }

    companion object {


        private val TAG = AlbumListPresenter::class.java.getSimpleName()
    }

}