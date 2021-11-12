package com.example.deutschenachrichten.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deutschenachrichten.BuildConfig
import com.example.deutschenachrichten.data.model.NewsResponse
import com.example.deutschenachrichten.databinding.FragmentListBinding
import com.example.deutschenachrichten.ui.adapter.ArticleAdapter
import com.example.deutschenachrichten.ui.viewmodel.NewsViewModel
import com.example.deutschenachrichten.utils.Status
//import com.example.weatherapp.BuildConfig
//import com.example.weatherapp.R
//import com.example.weatherapp.data.model.ForecastResponse
//import com.example.weatherapp.data.model.WeatherResponse
//import com.example.weatherapp.databinding.FragmentListBinding
//import com.example.weatherapp.ui.adapter.ClickListener
//import com.example.weatherapp.ui.adapter.newsAdapter
//import com.example.weatherapp.ui.viewmodel.newsViewModel
//import com.example.weatherapp.ui.viewmodel.WeatherViewModel
//import com.example.weatherapp.utils.Status
import retrofit2.Response


class ListFragment : Fragment() {
    private val TAG = "ListFragment"

    lateinit var binding: FragmentListBinding
    private val newsViewModel: NewsViewModel by activityViewModels()
    private val newsAdapter by lazy { ArticleAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        initUI()
        initAPI()
        return binding.root
    }

    fun initUI() {
        binding.apply {
//            toolbarTitle.text =
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = newsAdapter
                addItemDecoration(
                    DividerItemDecoration(
                        context,
                        (layoutManager as LinearLayoutManager).orientation
                    )
                )

            }
        }

    }

    private fun initAPI() {
        newsViewModel.fetchNews(BuildConfig.API_KEY)
            .observe(viewLifecycleOwner) {
                when (it.status) {
                    Status.SUCCESS -> {
                        Log.i(TAG, "Success: ${it}")
//                    binding.progressBar.visibility = View.INVISIBLE
                        it.data?.let { usersData -> renderList(usersData) }
//                        binding.recyclerView.visibility = View.INVISIBLE
                    }
                    Status.LOADING -> {
                        Log.i(TAG, "Loading: ${it.message}")
//                    binding.progressBar.visibility = View.INVISIBLE
//                        binding.recyclerView.visibility = View.INVISIBLE
                    }
                    Status.ERROR -> {
                        //Handle Error
                        Log.d(TAG, "Error: ${it.message}")
//                    binding.progressBar.visibility = View.INVISIBLE
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
    }

    private fun renderList(articles: Response<NewsResponse>) {
        newsAdapter.apply {
            Log.d(TAG, "renderList: ${articles.body()?.articles?.size}")
            articles.body()?.articles?.let { addData(it) }
        }
    }
}