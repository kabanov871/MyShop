package com.example.myshop.presentation.secondScreen

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.myshop.R
import com.example.myshop.databinding.FragmentDetailBinding
import com.example.myshop.presentation.MyApp
import com.example.myshop.presentation.ViewModelFactory
import com.example.myshop.presentation.utils.Status
import com.example.myshop.presentation.viewModels.HomeViewModel
import com.squareup.picasso.Picasso
import javax.inject.Inject


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: HomeViewModel

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
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
        binding.cardView1.strokeColor = resources.getColor(R.color.card_selector)

        init()

        binding.imageBack.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.frame, HomeFragment.newInstance())
                ?.commit()
        }

        return binding.root
    }

    private fun init() {
        viewModel.getDetail().observe(viewLifecycleOwner) {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let {
                            val imageList = it.image_urls
                            val colorsList = it.colors
                            binding.apply {
                                textName.text = it.name
                                tvPrice.text = "$ ${it.price.toString()}"
                                tvDesc.text = it.description
                                tvRating.text = it.rating.toString()
                                tvReviews.text = "(${it.number_of_reviews})"

                                setColor(colorsList)
                                setImage(imageList)
                                setCount(it.price)
                            }
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(context, R.string.load_fail, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                }
            }
        }
    }

    private fun setColor(colorsList: List<String>) {
        binding.apply {
            cardView4.background.setTint(Color.parseColor(colorsList[0]))
            cardView5.background.setTint(Color.parseColor(colorsList[1]))
            cardView6.background.setTint(Color.parseColor(colorsList[2]))

            cardView4.setOnClickListener {
                cardView4.strokeColor = resources.getColor(R.color.card_selector)
                cardView5.strokeColor = resources.getColor(R.color.background)
                cardView6.strokeColor = resources.getColor(R.color.background)
            }

            cardView5.setOnClickListener {
                cardView4.strokeColor = resources.getColor(R.color.background)
                cardView5.strokeColor = resources.getColor(R.color.card_selector)
                cardView6.strokeColor = resources.getColor(R.color.background)
            }

            cardView6.setOnClickListener {
                cardView4.strokeColor = resources.getColor(R.color.background)
                cardView5.strokeColor = resources.getColor(R.color.background)
                cardView6.strokeColor = resources.getColor(R.color.card_selector)
            }
        }
    }

    private fun setImage(imageList: List<String>) {
        binding.apply {
            Picasso.get().load(imageList[0]).into(binding.imageView9)
            Picasso.get().load(imageList[0]).into(binding.image1)
            Picasso.get().load(imageList[1]).into(binding.image2)
            Picasso.get().load(imageList[2]).into(binding.image3)

            cardView1.setOnClickListener {
                Picasso.get().load(imageList[0]).into(binding.imageView9)
                cardView1.strokeColor = resources.getColor(R.color.card_selector)
                cardView2.strokeColor = resources.getColor(R.color.white)
                cardView3.strokeColor = resources.getColor(R.color.white)
            }

            cardView2.setOnClickListener {
                Picasso.get().load(imageList[1]).into(binding.imageView9)
                cardView1.strokeColor = resources.getColor(R.color.white)
                cardView2.strokeColor = resources.getColor(R.color.card_selector)
                cardView3.strokeColor = resources.getColor(R.color.white)
            }

            cardView3.setOnClickListener {
                Picasso.get().load(imageList[2]).into(binding.imageView9)
                cardView1.strokeColor = resources.getColor(R.color.white)
                cardView2.strokeColor = resources.getColor(R.color.white)
                cardView3.strokeColor = resources.getColor(R.color.card_selector)
            }
        }
    }

    private fun setCount(price: Int) {
        binding.apply {
            var actualCount = price
            textViewSum.text = actualCount.toString()
            button6.setOnClickListener {
                val liveCount = actualCount + price
                actualCount = liveCount
                textViewSum.text = actualCount.toString()
            }
            button5.setOnClickListener {
                if (actualCount > price) {
                    val liveCount = actualCount - price
                    actualCount = liveCount
                    textViewSum.text = actualCount.toString()
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DetailFragment()
    }
}