package com.example.weatherapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapplication.R
import com.example.weatherapplication.adapter.FutureAdapter
import com.example.weatherapplication.adapter.HourlyAdapter
import com.example.weatherapplication.databinding.ActivityFutureBinding
import com.example.weatherapplication.databinding.ActivityMainBinding
import com.example.weatherapplication.model.FutureData
import com.example.weatherapplication.model.HourlyData

class FutureActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFutureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFutureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        val itemList: ArrayList<FutureData> = ArrayList()
        itemList.add(FutureData("Mon", "snow", "snow", 27, 7))
        itemList.add(FutureData("Mon", "cloudy_sunny", "cloudy", 28, 10))
        itemList.add(FutureData("Mon", "sunny", "sunny", 32, 12))
        itemList.add(FutureData("Mon", "thunder", "thunder", 25, 5))
        itemList.add(FutureData("Mon", "cloudy_sunny", "cloudy sunny", 29, 10))
        itemList.add(FutureData("Mon", "snow", "snow", 22, 7))

        initRecyclerView(itemList)
    }

    private fun initRecyclerView(list: List<FutureData>){
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.futureRecycler.apply {
            layoutManager = mLayoutManager
            adapter = FutureAdapter(list, this@FutureActivity)
        }
    }
}