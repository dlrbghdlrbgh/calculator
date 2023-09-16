package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 1
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 2 삭제
//        setContentView(R.layout.activity_main)
        // 3
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /**
         * 1. num1 클릭시 result에 1이 표시된다
         * 2. 1.다음 + 클릭시 result에 1+가 표시된다
         * 3. 2.다음 num1클릭시 result에 1+1이 표시된다
         * 4. 3.다음 = 클릭시 result에 2가 표시된다
         */

        binding.num1.setOnClickListener {
            if (binding.result.text.toString() == "1+") {
                binding.result.setText("1+1")
            } else {
                binding.result.setText("1")
            }
        }

        binding.plus.setOnClickListener {
            binding.result.setText("1+")
        }

        binding.doCalculate.setOnClickListener {
//            binding.result.setText("2")

            val result = binding.result.text.toString()

            if(result.contains("+")){
                val numbers = result.split("+")

                val firstNumber = numbers[0]
                val secondNumber = numbers[1]
                val calculateString = firstNumber + secondNumber

                binding.result.setText(calculateString)

                val firstNum = firstNumber.toInt()
                val secondNum = secondNumber.toInt()
                val calculateResult = firstNum + secondNum //Math.addExact(firstNum, secondNum)

                binding.result.setText(calculateResult.toString())
            }

        }


    }
}