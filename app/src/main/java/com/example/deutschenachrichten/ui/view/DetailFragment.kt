package com.example.deutschenachrichten.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.deutschenachrichten.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.fragment_detail.*
import okhttp3.internal.trimSubstring

class DetailFragment : Fragment(){
    private lateinit var binding : FragmentDetailBinding
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    fun initUI() {
        binding.apply {
            toolbarTitle.text = args.city
//            tvMainTemp.text = args.newsResponse.main?.temp.toString().trimSubstring(0,2)
            btnButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }

    }

}