package com.shahriar.bmi_calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class BmiViewModel : ViewModel() {

    // LiveData for weight and height inputs
    val weight = MutableLiveData<String>()
    val height = MutableLiveData<String>()

    // LiveData for the calculated BMI and its category
    private val _bmiResult = MutableLiveData<Float>()
    val bmiResult: LiveData<Float> = _bmiResult

    private val _bmiCategory = MutableLiveData<String>()
    val bmiCategory: LiveData<String> = _bmiCategory

    // Function to calculate BMI
    fun calculateBMI() {
        val weightValue = weight.value?.toFloatOrNull() ?: 0f
        val heightValue = height.value?.toFloatOrNull() ?: 0f

        if (weightValue > 0 && heightValue > 0) {
            val bmi = BMICalculator.calculateBMI(weightValue, heightValue)
            _bmiResult.value = bmi
            _bmiCategory.value = BMICalculator.getBMICategory(bmi)
        } else {
            _bmiResult.value = 0f
            _bmiCategory.value = "Invalid input"
        }
    }
}
