package com.example.myshop.presentation.secondScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myshop.databinding.FragmentSaleBinding

class SaleFragment : Fragment() {

    private lateinit var binding: FragmentSaleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSaleBinding.inflate(inflater, container, false)
        return binding.root
    }
    companion object{
        @JvmStatic
        fun newInstance() = SaleFragment()
    }
}