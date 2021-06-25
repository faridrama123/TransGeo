package com.faridrama123.transgeo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faridrama123.transgeo.R
import com.faridrama123.transgeo.databinding.ListTransformBinding
import com.faridrama123.transgeo.ui.model.Transform

import java.util.ArrayList

class TransformAdapter : RecyclerView.Adapter<TransformAdapter.ViewHolder>() {

    private var listData = ArrayList<Transform>()
    var onItemClick : ((Transform) -> Unit)? = null

    fun setData(newListData: List<Transform>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }


    inner  class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListTransformBinding.bind(itemView)
        fun bind (data : Transform){
            with(binding){
                image1.setImageResource(data.imageResource);

            }

        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_transform, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}