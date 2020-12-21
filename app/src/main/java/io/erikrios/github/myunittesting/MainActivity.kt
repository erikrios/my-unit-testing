package io.erikrios.github.myunittesting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.erikrios.github.myunittesting.databinding.ActivityMainBinding
import io.erikrios.github.myunittesting.models.CuboidModel
import io.erikrios.github.myunittesting.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainViewModel = MainViewModel(CuboidModel())
    }
}