package com.example.myshop.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.R
import com.example.myshop.databinding.FlashSaleItemBinding
import com.example.myshop.domain.models.FlashSaleModel
import com.squareup.picasso.Picasso

class FlashSaleAdapter(
    private val openDetailFragment:() -> Unit
): RecyclerView.Adapter<FlashSaleAdapter.FlashSaleHolder>() {

    private val flashSaleList = ArrayList<FlashSaleModel>()

    class FlashSaleHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = FlashSaleItemBinding.bind(item)
        @SuppressLint("SetTextI18n")
        fun bind(model: FlashSaleModel, openDetailFragment:() -> Unit) = with(binding) {
            val getImage = model.image_url
            Picasso.get().load(getImage).into(imageFlashSale)
            textViewDiscount.text = "${model.discount}% off"
            textPrice.text = model.price.toString()
            textDesc.text = model.name
            textCategory.text = model.category
            card.setOnClickListener {
                openDetailFragment()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashSaleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flash_sale_item, parent, false)
        return FlashSaleHolder(view)
    }

    override fun onBindViewHolder(holder: FlashSaleHolder, position: Int) {
        holder.bind(flashSaleList[position], openDetailFragment)

    }

    override fun getItemCount(): Int {
        return flashSaleList.size

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<FlashSaleModel>) {
        flashSaleList.clear()
        flashSaleList.addAll(list)
        notifyDataSetChanged()
    }
}