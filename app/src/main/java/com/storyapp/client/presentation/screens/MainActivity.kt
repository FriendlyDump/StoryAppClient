package com.storyapp.client.presentation.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.storyapp.client.R
import com.storyapp.client.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, RegistrationFragment()).commitAllowingStateLoss()
        }
    }
}