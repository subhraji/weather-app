package com.example.weatherapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapplication.databinding.FutureItemLayoutBinding
import com.example.weatherapplication.model.FutureData

class FutureAdapter(private val itemList: List<FutureData>, private val context: Context):
    RecyclerView.Adapter<FutureAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FutureAdapter.ViewHolder {
        val itemBinding = FutureItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FutureAdapter.ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: FutureAdapter.ViewHolder, position: Int) {
        val rowData = itemList[position]
        holder.bind(rowData, context)
    }

    class ViewHolder(private val itemBinding: FutureItemLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: FutureData, context: Context) {
            itemBinding.apply {
                dayTv.text = data.day
                weatherTv.text = data.status
                lowTempTv.text = "${data.lowTemp}º"
                highTempTv.text = "${data.highTemp}º"

                val drawableResourceId = context.getResources().getIdentifier(data.picPath, "drawable", context.getPackageName());
                Glide.with(context)
                    .load(drawableResourceId)
                    .into(imageView)
            }
        }
    }
}