package com.example.myshop.presentation.secondScreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshop.R
import com.example.myshop.databinding.FragmentHomeBinding
import com.example.myshop.domain.models.LatestModel
import com.example.myshop.presentation.MyApp
import com.example.myshop.presentation.utils.Status
import com.example.myshop.presentation.ViewModelFactory
import com.example.myshop.presentation.adapters.BrandsAdapter
import com.example.myshop.presentation.adapters.FlashSaleAdapter
import com.example.myshop.presentation.adapters.LatestAdapter
import com.example.myshop.presentation.viewModels.HomeViewModel
import javax.inject.Inject


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var latestAdapter: LatestAdapter
    private lateinit var flashSaleAdapter: FlashSaleAdapter
    private lateinit var brandsAdapter: BrandsAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as MyApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]

        binding.recyclerLatest.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        latestAdapter = LatestAdapter()
        binding.recyclerLatest.adapter = latestAdapter

        binding.recyclerFlashSale.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        flashSaleAdapter = FlashSaleAdapter { openDetailFragment() }
        binding.recyclerFlashSale.adapter = flashSaleAdapter

        binding.recyclerBrands.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        brandsAdapter = BrandsAdapter()
        binding.recyclerBrands.adapter = brandsAdapter

        init()
        displayBrands()

        return binding.root
    }

    private fun init() {

        viewModel.getLatest().observe(viewLifecycleOwner) {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let {
                            getFlashSale(it)
                        }
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(context, R.string.load_fail, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                }
            }
        }
    }
    private fun getFlashSale(listLatest: List<LatestModel>) {

        viewModel.getFlashSale().observe(viewLifecycleOwner) {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.constraintLatest.visibility = View.VISIBLE
                        binding.constraintFlashSale.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        resource.data?.let {
                            flashSaleAdapter.setList(it)
                            latestAdapter.setList(listLatest)
                        }
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(context, R.string.load_fail, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                }
            }
        }
    }

    private fun displayBrands() {
        brandsAdapter.setList(arrayListOf(1,1,1,1,1,1))
    }

    private fun openDetailFragment() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.frame, DetailFragment.newInstance())
            ?.addToBackStack("Later Transaction")
            ?.commit()
    }

    companion object{
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}