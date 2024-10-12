package com.shahriar.bmi_calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.shahriar.bmi_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: BmiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup Data Binding and View Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this)[BmiViewModel::class.java]

        // Bind ViewModel to layout
        binding.viewModel = viewModel
        binding.lifecycleOwner = this  // Observes LiveData changes

    }
}