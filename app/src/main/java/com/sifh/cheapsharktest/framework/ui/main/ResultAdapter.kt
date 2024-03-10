package com.sifh.cheapsharktest.framework.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sifh.cheapsharktest.R
import com.sifh.cheapsharktest.databinding.ItemBinding
import com.sifh.cheapsharktest.domain.Result
import com.sifh.cheapsharktest.framework.ui.common.basicDiffUtil

class ResultAdapter() : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {
    var results: List<Result> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results.get(position)
        holder.bind(result)
    }

    override fun getItemCount(): Int = results.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemBinding.bind(view)
        fun bind(result: Result?) = with(binding) {
            txtTitle.text = result?.title
            txtSteamRatingText.text = result?.steamRatingText
            "${result?.salePrice.toString() } USD".also { txtSalePrice.text = it }
        }
    }

}