package com.rommelrico.androidsounddemo

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import java.util.*

class MainActivity : AppCompatActivity() {

    var mediaPlayer: MediaPlayer? = null
    var audioManager: AudioManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer = MediaPlayer.create(this, R.raw.marbles)

        // Max and Current Volume
        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager?
        val maxVolume = audioManager?.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        var currentVolume = audioManager?.getStreamVolume(AudioManager.STREAM_MUSIC)

        // Handling the seekbar.
        val volumeControl = findViewById<SeekBar>(R.id.volumeSeekBar)
        volumeControl.max = maxVolume ?: 0
        volumeControl.progress = currentVolume ?: 0

        // SeekBar Listener.
        volumeControl.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                audioManager?.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        // Scrub Seek Bar.
        val scrubSeekBar = findViewById<SeekBar>(R.id.scrubSeekBar)

        // Max value
        scrubSeekBar.max = mediaPlayer?.duration ?: 0

        // Scrub SeekBar Listener.
        scrubSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mediaPlayer?.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        // Timer.
        Timer().scheduleAtFixedRate(object: TimerTask() {

            override fun run() {
                scrubSeekBar.progress = mediaPlayer?.currentPosition ?: 0
            }

        }, 0, 300)


    } // end onCreate.

    fun play(view: View) {
        mediaPlayer?.start()
    }

    fun pause(view: View) {
        mediaPlayer?.pause()
    }
}
