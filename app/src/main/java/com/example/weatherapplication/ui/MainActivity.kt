package com.example.weatherapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapplication.adapter.HourlyAdapter
import com.example.weatherapplication.databinding.ActivityMainBinding
import com.example.weatherapplication.model.HourlyData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextdayTv.setOnClickListener {
            val intent = Intent(this, FutureActivity::class.java)
            startActivity(intent)
        }

        val itemList: ArrayList<HourlyData> = ArrayList()
        itemList.add(HourlyData("Now", 18, "snow"))
        itemList.add(HourlyData("15:00", 17, "cloudy_sunny"))
        itemList.add(HourlyData("16:00", 17, "sunny"))
        itemList.add(HourlyData("17:00", 16, "cloudy_sunny"))
        itemList.add(HourlyData("17:33", 15, "thunder"))
        itemList.add(HourlyData("18:00", 18, "cloudy_sunny"))

        initRecyclerView(itemList)
    }

    private fun initRecyclerView(list: List<HourlyData>){
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.hourlyRecycler.apply {
            layoutManager = mLayoutManager
            adapter = HourlyAdapter(list,this@MainActivity)
        }
    }
}