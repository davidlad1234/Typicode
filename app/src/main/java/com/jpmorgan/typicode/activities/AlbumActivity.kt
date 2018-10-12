package com.jpmorgan.typicode.activities

import android.support.v7.app.AppCompatActivity

abstract class AlbumActivity : AppCompatActivity() {
    var currentStatus: Int = 0

    override fun onStart() {
        super.onStart()
        currentStatus = STATUS_STARTED
    }

    override fun onPause() {
        super.onPause()
        currentStatus = STATUS_PAUSED
    }

    override fun onResume() {
        super.onResume()
        currentStatus = STATUS_RESUMED
    }

    override fun onStop() {
        super.onStop()
        currentStatus = STATUS_STOPPED
    }

    companion object {

        const val STATUS_STARTED = 1
        const val STATUS_RESUMED = 2
        const val STATUS_PAUSED = 3
        const val STATUS_STOPPED = 4
    }


}
