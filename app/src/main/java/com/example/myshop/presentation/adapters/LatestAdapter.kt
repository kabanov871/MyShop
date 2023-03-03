package com.example.myshop.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.R
import com.example.myshop.data.models.latest.Latest
import com.example.myshop.databinding.BrandsItemBinding
import com.example.myshop.databinding.LatestItemBinding
import com.example.myshop.domain.models.LatestModel
import com.squareup.picasso.Picasso

class LatestAdapter: RecyclerView.Adapter<LatestAdapter.LatestHolder>() {

    private val latestList = ArrayList<LatestModel>()

    class LatestHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = LatestItemBinding.bind(item)
        fun bind(model: LatestModel) = with(binding) {
            val getImage = model.image_url
            Picasso.get().load(getImage).into(imageProduct)
            textViewCategory.text = model.category
            textViewName.text = model.name
            textViewPrice.text = model.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.latest_item, parent, false)
        return LatestHolder(view)
    }

    override fun onBindViewHolder(holder: LatestHolder, position: Int) {
        holder.bind(latestList[position])

    }

    override fun getItemCount(): Int {
        return latestList.size

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<LatestModel>) {
        latestList.clear()
        latestList.addAll(list)
        notifyDataSetChanged()
    }
}