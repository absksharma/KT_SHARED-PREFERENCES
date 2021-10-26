package com.example.kt_shared_preferences

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kt_shared_preferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var sPref = getPreferences(MODE_PRIVATE)
        var color = sPref.getInt("COLOR", Color.WHITE)
        binding.llBackground.setBackgroundColor(color)

        fun saveColor(color: Int) {
            var editor = sPref.edit()
            editor.putInt("COLOR", color)
            editor.apply()
        }


        binding.red.setOnClickListener {
            binding.llBackground.setBackgroundColor(Color.RED)
             saveColor(Color.RED)
        }
        binding.green.setOnClickListener {
            binding.llBackground.setBackgroundColor(Color.GREEN)
            saveColor(Color.GREEN)

        }
        binding.yellow.setOnClickListener {
            binding.llBackground.setBackgroundColor(Color.YELLOW)
            saveColor(Color.YELLOW)
        }
    }
}