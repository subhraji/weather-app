package com.example.weatherapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapplication.R
import com.example.weatherapplication.adapter.FutureAdapter
import com.example.weatherapplication.adapter.HourlyAdapter
import com.example.weatherapplication.databinding.ActivityHomeBinding
import com.example.weatherapplication.databinding.ActivityMainBinding
import com.example.weatherapplication.model.FutureData
import com.example.weatherapplication.model.HourlyData

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemList: ArrayList<HourlyData> = ArrayList()
        itemList.add(HourlyData("9 AM", 22, "snow"))
        itemList.add(HourlyData("10 AM", 25, "cloudy_sunny"))
        itemList.add(HourlyData("11 AM", 28, "sunny"))
        itemList.add(HourlyData("12 PM", 27, "cloudy_sunny"))
        itemList.add(HourlyData("1 PM", 24, "thunder"))
        itemList.add(HourlyData("2 PM", 32, "cloudy_sunny"))

        initHourlyRecyclerView(itemList)

        val dataList: ArrayList<FutureData> = ArrayList()
        dataList.add(FutureData("Today", "snow", "snow", 27, 7))
        dataList.add(FutureData("Tomorrow", "cloudy_sunny", "cloudy", 28, 10))
        dataList.add(FutureData("Thu", "sunny", "sunny", 32, 12))
        dataList.add(FutureData("Fri", "thunder", "thunder", 25, 5))
        dataList.add(FutureData("Sat", "cloudy_sunny", "cloudy sunny", 29, 10))
        dataList.add(FutureData("Sun", "sunny", "sunny", 22, 7))
        dataList.add(FutureData("Mon", "sunny", "sunny", 22, 7))
        initWeeklyRecyclerView(dataList)
    }
    private fun initHourlyRecyclerView(list: List<HourlyData>){
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.hourlyRecycler.apply {
            layoutManager = mLayoutManager
            adapter = HourlyAdapter(list,this@HomeActivity)
        }
    }
    private fun initWeeklyRecyclerView(list: List<FutureData>){
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.weeklyRecycler.apply {
            layoutManager = mLayoutManager
            adapter = FutureAdapter(list, this@HomeActivity)
        }
    }
}