package com.example.deutschenachrichten.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.deutschenachrichten.data.model.NewsResponse
import com.example.deutschenachrichten.databinding.ItemNewsBinding
import com.example.deutschenachrichten.ui.view.ListFragmentDirections
//import com.example.weatherapp.R
//import com.example.weatherapp.data.model.ForecastResponse
//import com.example.weatherapp.data.model.NewsResponse
//import com.example.weatherapp.databinding.ItemNewsBinding
//import com.example.weatherapp.ui.view.ListFragmentDirections
//import kotlinx.android.synthetic.main.item_weather.view.*
import okhttp3.internal.trimSubstring
import retrofit2.Response
import javax.inject.Inject
import kotlin.math.log

class NewsAdapter @Inject constructor(
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    private val items = mutableListOf<NewsResponse>()
    private lateinit var city: String
    

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = items[position]
        Log.d("newsAdapter", "onBindViewHolder: $item")
        holder.bind(item)
        val action =
            item.let {
                ListFragmentDirections.actionListFragmentToDetailFragment(
                    it, city
                )
            }
        holder.itemView.setOnClickListener {
            action.let { NewsResponse -> it.findNavController().navigate(NewsResponse) }
//            Toast.makeText(holder.itemView.context, items[position], Toast.LENGTH_SHORT).show()
        }
    }

    class NewsViewHolder(itemView: ItemNewsBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val TAG = "NewsViewHolder"
            fun bind(item: NewsResponse) {
//            val weather = item.weather.get(0).description.toString()
//            val temp = item.main?.temp.toString().trimSubstring(0,2)
            Log.d(TAG, "bind: ")
//            itemView.tv_weather.text = weather
//            itemView.tv_temp.text = "Temp ${temp}"
        }
    }

    fun addData(items: List<NewsResponse>, city: String) {
        this.city = city
        this.items.apply {
            clear()
            addAll(items)
            notifyDataSetChanged()
        }
    }
}