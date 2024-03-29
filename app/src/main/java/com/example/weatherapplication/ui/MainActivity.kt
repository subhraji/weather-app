package com.example.weatherapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapplication.R
import com.example.weatherapplication.adapter.FutureAdapter
import com.example.weatherapplication.adapter.HourlyAdapter
import com.example.weatherapplication.adapter.WeatherAdapter
import com.example.weatherapplication.databinding.ActivityMainBinding
import com.example.weatherapplication.model.FutureData
import com.example.weatherapplication.model.HourlyData
import com.example.weatherapplication.model.WeatherData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemList: ArrayList<HourlyData> = ArrayList()
        itemList.add(HourlyData("Now", 22, "cloudy"))
        itemList.add(HourlyData("15:00", 25, "fog"))
        itemList.add(HourlyData("16:00", 28, "sunny"))
        itemList.add(HourlyData("17:00", 27, "thunder"))
        itemList.add(HourlyData("17:33", 24, "cloudy_sunny"))
        itemList.add(HourlyData("18:00", 32, "cloudy_sunny"))
        initHourlyRecyclerView(itemList)

        val dataList: ArrayList<FutureData> = ArrayList()
        dataList.add(FutureData("Today", "cloudy", "Cloudy", 27, 7))
        dataList.add(FutureData("Tomorrow", "snow", "Snow", 28, 10))
        dataList.add(FutureData("Thu", "sunny", "Sunny", 32, 12))
        dataList.add(FutureData("Fri", "thunder", "Thunder", 25, 5))
        dataList.add(FutureData("Sat", "cloudy_sunny", "Partly cloudy", 29, 10))
        dataList.add(FutureData("Sun", "sunny", "Sunny", 22, 7))
        dataList.add(FutureData("Mon", "sunny", "Sunny", 22, 7))
        initWeeklyRecyclerView(dataList)

        val weatherList: ArrayList<WeatherData> = ArrayList()
        weatherList.add(WeatherData("temp", "Feels like", "16º", ""))
        weatherList.add(WeatherData("wind", "W wind", "13", "km/h"))
        weatherList.add(WeatherData("humidity", "Humidity", "62", "%"))
        weatherList.add(WeatherData("sunny", "UV", "0", "very weak"))
        weatherList.add(WeatherData("visibility", "Visibility", "1","km"))
        weatherList.add(WeatherData("air", "Air pressure", "1017","hPa"))
        initWeatherRecyclerView(weatherList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initHourlyRecyclerView(list: List<HourlyData>){
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.hourlyRecycler.apply {
            layoutManager = mLayoutManager
            adapter = HourlyAdapter(list,this@MainActivity)
        }
    }
    private fun initWeeklyRecyclerView(list: List<FutureData>){
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.weeklyRecycler.apply {
            layoutManager = mLayoutManager
            adapter = FutureAdapter(list, this@MainActivity)
        }
    }
    private fun initWeatherRecyclerView(list: List<WeatherData>){
        val mLayoutManager = GridLayoutManager(this, 2)
        binding.weatherRecycler.apply {
            layoutManager = mLayoutManager
            adapter = WeatherAdapter(list, this@MainActivity)
        }
    }
}