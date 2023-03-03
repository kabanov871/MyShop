package com.example.myshop.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.R
import com.example.myshop.databinding.BrandsItemBinding

class BrandsAdapter: RecyclerView.Adapter<BrandsAdapter.BrandsHolder>() {

    private val brandsList = ArrayList<Int>()

    class BrandsHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = BrandsItemBinding.bind(item)
        @SuppressLint("SetTextI18n")
        fun bind(model: Int) = with(binding) {
            imageBrand.setImageResource(R.drawable.brand_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.brands_item, parent, false)
        return BrandsHolder(view)
    }

    override fun onBindViewHolder(holder: BrandsHolder, position: Int) {
        holder.bind(brandsList[position])

    }

    override fun getItemCount(): Int {
        return brandsList.size

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Int>) {
        brandsList.clear()
        brandsList.addAll(list)
        notifyDataSetChanged()
    }
}