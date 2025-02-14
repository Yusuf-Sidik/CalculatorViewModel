package com.example.calculatorviewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculatorviewmodel.databinding.ActivityMainBinding
import com.example.calculatorviewmodel.databinding.ActivityRecycleViewBinding

class RecycleViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecycleViewBinding
    private lateinit var rvModel: RecycleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycleViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvModel = ViewModelProvider(this).get(RecycleViewModel::class.java)
        rvModel.loadData()

        binding.rvHero.layoutManager = LinearLayoutManager(this)
        binding.rvHero.adapter = DataAdapter(rvModel.list)
    }
}