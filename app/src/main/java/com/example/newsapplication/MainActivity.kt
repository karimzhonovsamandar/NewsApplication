package com.example.newsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var _binding :ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        Handler(Looper.myLooper()!!).postDelayed({
            setContentView(binding.root)
            bottom_nav_menu.setupWithNavController(nav_host_fragment.findNavController())
        }, 5000)

        setContentView(R.layout.fragment_splash)



    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}