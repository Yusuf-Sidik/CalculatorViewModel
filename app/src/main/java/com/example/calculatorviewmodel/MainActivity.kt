package com.example.calculatorviewmodel

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calculatorviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val result = (binding.edtLength.text.toString().toDouble() * binding.edtWidth.text.toString().toDouble() * binding.edtHeight.text.toString().toDouble())

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        binding.btnCalculate.setOnClickListener {
            val width = binding.edtWidth.text.toString()
            val length = binding.edtLength.text.toString()
            val height = binding.edtHeight.text.toString()

            when {
                width.isEmpty() -> {
                    binding.edtWidth.error = "Masih kosong"
                }
                length.isEmpty() -> {
                    binding.edtLength.error = "Masih kosong"
                }
                height.isEmpty() -> {
                    binding.edtHeight.error = "Masih kosong"
                }
                else -> {
                    viewModel.calculate(width, length, height)
                    displayResult()
                }
            }
        }

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this@MainActivity, RecycleViewActivity::class.java))
        }


    }

    private fun displayResult() {
        binding.tvResult.text = viewModel.result.toString()
    }
}