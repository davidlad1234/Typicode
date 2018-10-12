package com.jpmorgan.typicode.activities

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.OnClick
import com.jpmorgan.typecode.R
import com.jpmorgan.typicode.pojos.Album
import com.jpmorgan.typicode.presenters.AlbumListPresenter
import com.jpmorgan.typicode.utils.AlbumRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_album_list.*
import kotlinx.android.synthetic.main.album_list.*
import java.lang.ref.WeakReference

/**
 * An activity representing a list of ResponseModel. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of ResponseModel
 */
class AlbumListActivity : AlbumActivity(), LocalCallback, ActivityCallback {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var isTwoPane: Boolean = false

    //@TODO inject using Dagger
    lateinit var albumListPresenter: AlbumListPresenter

    protected var toast: Toast? = null

    override val context: Context
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_list)
        ButterKnife.bind(this)
        albumListPresenter = AlbumListPresenter()
        setSupportActionBar(toolbar)
        setTitles()

        if (album_detail_container != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            isTwoPane = true
        }
        assert(album_list != null)
        //
    }

    private fun setTitles() {
        setTitle(R.string.album_list_test)
        toolbar!!.title = title
    }

    public override fun onStart() {
        super.onStart()
        albumListPresenter.fetchPhotos(WeakReference(this))
    }

    @OnClick(R.id.fab)
    fun onClickFab(view: View) {
        Snackbar.make(view, "Album list display ", Snackbar.LENGTH_LONG)
                .show()
    }

    override fun showAlbums(albums: Array<Album>) {

        album_list!!.adapter = AlbumRecyclerViewAdapter(this@AlbumListActivity, albums)

    }

    override fun showErrorMessage(message: String) {
        toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast!!.show()
    }

    override fun showErrorMessage(server_error: Int) {
        toast = Toast.makeText(this, getString(R.string.data_error), Toast.LENGTH_LONG)
        toast!!.show()
    }

    public override fun onStop() {
        super.onStop()
        albumListPresenter.onStop()
    }

        override fun processCall(album: Album) {
        //does nothing in this implementation ..provides ability to introspect or use single album data
        Log.d(TAG, "Received album.....")
    }

    companion object {

        private val TAG = AlbumListActivity::class.java.javaClass.getSimpleName()
    }
}
