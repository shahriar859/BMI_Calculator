package com.shahriar.bmi_calculator

object BMICalculator {
    fun calculateBMI(weight: Float, height: Float): Float {
        return if (height > 0) {
            (weight / (height * height))
        } else {
            0f
        }
    }

    fun getBMICategory(bmi: Float): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi in 18.5..24.9 -> "Normal weight"
            bmi in 25.0..29.9 -> "Overweight"
            else -> "Obese"
        }
    }
}
