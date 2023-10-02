package com.illinodes.pula.rvAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.illinodes.pula.R
import com.illinodes.pula.model.DTO.Daily
import java.text.SimpleDateFormat

class ForecastAdapter(private val weatherForecastList: List<Daily>):
    RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {
    private val simpleDate = SimpleDateFormat("dd/M/yyyy hh:mm:ss")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.item_weather_forecast,
            parent, false))
    }

    override fun getItemCount(): Int {
        return weatherForecastList.size
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.txtWeekday.text = simpleDate.format(weatherForecastList[position].dt)
        holder.txtTemp.text = "${weatherForecastList[position].feels_like.day.toInt()}\u00B0"
    }

    inner class ForecastViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtWeekday = itemView.findViewById<TextView>(R.id.txtWeekday)
        var txtTemp = itemView.findViewById<TextView>(R.id.txtTemperature)
    }
}