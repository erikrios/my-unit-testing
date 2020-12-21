package io.erikrios.github.myunittesting

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.erikrios.github.myunittesting.databinding.ActivityMainBinding
import io.erikrios.github.myunittesting.models.CuboidModel
import io.erikrios.github.myunittesting.viewmodels.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.apply {
            btnSave.setOnClickListener(this@MainActivity)
            btnCalculateVolume.setOnClickListener(this@MainActivity)
            btnCalculateCircumference.setOnClickListener(this@MainActivity)
            btnCalculateSurfaceArea.setOnClickListener(this@MainActivity)
        }


        mainViewModel = MainViewModel(CuboidModel())
    }


    override fun onClick(v: View?) {
        val length = binding.etLength.text.toString().trim()
        val width = binding.etWidth.text.toString().trim()
        val height = binding.etHeight.text.toString().trim()

        when {
            length.isEmpty() -> binding.etLength.error = getString(R.string.field_error_message)
            width.isEmpty() -> binding.etWidth.error = getString(R.string.field_error_message)
            height.isEmpty() -> binding.etHeight.error = getString(R.string.field_error_message)
            else -> {
                val l = length.toDouble()
                val w = width.toDouble()
                val h = height.toDouble()

                when {
                    v?.id == binding.btnSave.id -> {
                        mainViewModel.save(l, w, h)
                        visible()
                    }
                    v?.id == binding.btnCalculateCircumference.id -> {
                        binding.tvResult.text = mainViewModel.getCircumreference().toString()
                        gone()
                    }
                    v?.id == binding.btnCalculateSurfaceArea.id -> {
                        binding.tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    v?.id == binding.btnCalculateVolume.id -> {
                        binding.tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible() {
        binding.apply {
            btnCalculateVolume.visibility = View.VISIBLE
            btnCalculateCircumference.visibility = View.VISIBLE
            btnCalculateSurfaceArea.visibility = View.VISIBLE
            btnSave.visibility = View.GONE
        }
    }

    private fun gone() {
        binding.apply {
            btnCalculateVolume.visibility = View.GONE
            btnCalculateCircumference.visibility = View.GONE
            btnCalculateSurfaceArea.visibility = View.GONE
            btnSave.visibility = View.VISIBLE
        }
    }
}