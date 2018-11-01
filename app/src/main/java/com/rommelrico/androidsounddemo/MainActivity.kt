package com.rommelrico.androidsounddemo

import android.media.AudioManager
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    var mediaPlayer: MediaPlayer? = null
    var audioManager: AudioManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer = MediaPlayer.create(this, R.raw.marbles)

        // Max Volume
        val maxVolume = audioManager?.getStreamMaxVolume(AudioManager.STREAM_MUSIC)

        // Handling the seekbar.
        val volumeControl = findViewById<SeekBar>(R.id.volumeSeekBar)
        volumeControl.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

    } // end onCreate.

    fun play(view: View) {
        mediaPlayer?.start()
    }

    fun pause(view: View) {
        mediaPlayer?.pause()
    }
}
