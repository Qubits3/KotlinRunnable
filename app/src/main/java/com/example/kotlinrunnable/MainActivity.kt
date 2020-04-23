package com.example.kotlinrunnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number = 0
    private var runnable: Runnable = Runnable {  }
    private var handler: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view: View) {
        number = 0

        runnable = Runnable {
            number++
            textView.text = "Time: $number"

            handler.postDelayed(runnable, 1000)
        }

        handler.post(runnable)

    }

    fun stop(view: View) {

            handler.removeCallbacks(runnable)
            number = 0
            textView.text = "Time: 0"

    }
}
