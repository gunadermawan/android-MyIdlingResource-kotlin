package com.gunder.myidlingresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.gunder.myidlingresource.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //    binding
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.button.setOnClickListener {
            delay1()
            delay2()
        }
    }

    private fun delay2() {
        EspressoIdlingResource.increment()
        Handler(Looper.getMainLooper()).postDelayed({
            mainBinding.textView.text = getString(R.string.delay2)
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
//                memberitahu jika proses telah selesai dilaksanakan
                EspressoIdlingResource.decrement()
            }
        }, 2000)
    }

    private fun delay1() {
        EspressoIdlingResource.increment()
        Handler(Looper.getMainLooper()).postDelayed({
            mainBinding.textView.text = getString(R.string.delay1)
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
//                memberitahu ketikan proses sudah selesai dijalankan
                EspressoIdlingResource.decrement()
            }
        }, 2000)
    }
}