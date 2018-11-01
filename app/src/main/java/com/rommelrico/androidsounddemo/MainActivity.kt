package com.rommelrico.androidsounddemo

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer = MediaPlayer.create(this, R.raw.marbles)

        // Handling the seekbar.
        val volumeControl = findViewById<SeekBar>(R.id.volumeSeekBar)
    }

    fun play(view: View) {
        mediaPlayer?.start()
    }

    fun pause(view: View) {
        mediaPlayer?.pause()
    }
}
