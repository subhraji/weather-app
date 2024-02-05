package com.example.weatherapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapplication.databinding.WeatherDetailsItemLayoutBinding
import com.example.weatherapplication.model.WeatherData

class WeatherAdapter(private val itemList: List<WeatherData>, private val context: Context):
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ViewHolder {
        val itemBinding = WeatherDetailsItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WeatherAdapter.ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: WeatherAdapter.ViewHolder, position: Int) {
        val rowData = itemList[position]
        holder.bind(rowData, context)
    }

    class ViewHolder(private val itemBinding: WeatherDetailsItemLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: WeatherData, context: Context) {
            itemBinding.apply {
                typeTv.text = data.type
                unitTv.text = data.unit
                unitTypeTv.text = data.unitType
                val drawableResourceId = context.getResources().getIdentifier(data.picPath, "drawable", context.getPackageName());
                Glide.with(context)
                    .load(drawableResourceId)
                    .into(imageView)
            }
        }
    }
}