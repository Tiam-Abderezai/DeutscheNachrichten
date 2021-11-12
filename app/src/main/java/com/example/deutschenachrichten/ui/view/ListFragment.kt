package com.example.deutschenachrichten.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deutschenachrichten.BuildConfig
import com.example.deutschenachrichten.R
import com.example.deutschenachrichten.data.model.NewsResponse
import com.example.deutschenachrichten.databinding.FragmentListBinding
import com.example.deutschenachrichten.ui.adapter.NewsAdapter
import com.example.deutschenachrichten.ui.viewmodel.NewsViewModel
import com.example.weatherapp.utils.Status
//import com.example.weatherapp.BuildConfig
//import com.example.weatherapp.R
//import com.example.weatherapp.data.model.ForecastResponse
//import com.example.weatherapp.data.model.WeatherResponse
//import com.example.weatherapp.databinding.FragmentListBinding
//import com.example.weatherapp.ui.adapter.ClickListener
//import com.example.weatherapp.ui.adapter.newsAdapter
//import com.example.weatherapp.ui.viewmodel.ForecastViewModel
//import com.example.weatherapp.ui.viewmodel.WeatherViewModel
//import com.example.weatherapp.utils.Status
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Response
import javax.inject.Inject


class ListFragment : Fragment() {
    private val TAG = "ListFragment"

    lateinit var binding: FragmentListBinding
    private val forecastViewModel: NewsViewModel by activityViewModels()
    private val newsAdapter by lazy { NewsAdapter() }
    private val args by navArgs<ListFragmentArgs>()

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
            toolbarTitle.text = args.title
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
        forecastViewModel.fetchNews(args.title, "BuildConfig.API_KEY")
            .observe(viewLifecycleOwner) {
                when (it.status) {
                    Status.SUCCESS -> {
                        Log.i("ListFragment", "Success: ${it}")
//                    binding.progressBar.visibility = View.INVISIBLE
                        it.data?.let { usersData -> renderList(usersData) }
//                        binding.recyclerView.visibility = View.INVISIBLE
                    }
                    Status.LOADING -> {
                        Log.i("ListFragment", "Loading: ${it.message}")
//                    binding.progressBar.visibility = View.INVISIBLE
//                        binding.recyclerView.visibility = View.INVISIBLE
                    }
                    Status.ERROR -> {
                        //Handle Error
                        Log.d("ListFragment", "Error: ${it.message}")
//                    binding.progressBar.visibility = View.INVISIBLE
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
    }

    private fun renderList(items: Response<NewsResponse>) {
        newsAdapter.apply {

//            Log.d(TAG, "renderList: ${items.body()?.list?.size}")
//            items.body()?.list?.let { addData(it, args.city) }
        }
    }

//    override fun itemClicked(weather: WeatherResponse) {
//        val action = ListFragmentDirections.actionListFragmentToDetailFragment( cityName)
//        findNavController().navigate(action)
//    }
}