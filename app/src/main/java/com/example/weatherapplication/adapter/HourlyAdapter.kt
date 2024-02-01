package com.example.weatherapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.HourlyItemLayoutBinding
import com.example.weatherapplication.model.HourlyData
import com.example.weatherapplication.ui.FutureActivity

class HourlyAdapter(private val itemList: List<HourlyData>, private val context: Context):
    RecyclerView.Adapter<HourlyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyAdapter.ViewHolder {
        val itemBinding = HourlyItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HourlyAdapter.ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HourlyAdapter.ViewHolder, position: Int) {
        val rowData = itemList[position]
        holder.bind(rowData, context)
    }

    class ViewHolder(private val itemBinding: HourlyItemLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: HourlyData, context: Context) {
            itemBinding.apply {
                hourTv.text = data.hour
                tempTv.text = "${data.temp}º"
                val drawableResourceId = context.getResources().getIdentifier(data.picPath, "drawable", context.getPackageName());
                Glide.with(context)
                    .load(drawableResourceId)
                    .into(imageView)
                root.setOnClickListener {
                    val intent = Intent(context, FutureActivity::class.java)
                    context.startActivity(intent)
                }
            }
        }
    }
}