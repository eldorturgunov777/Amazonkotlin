package com.example.amazonkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by Eldor Turgunov on 24.05.2022.
 * Amazon kotlin
 * eldorturgunov777@gmail.com
 */
class EssentialAdapter(var context: Context, var items: ArrayList<Essential>) :
    RecyclerView.Adapter<EssentialAdapter.EssentialViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EssentialAdapter.EssentialViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_feed_essential, parent, false)
        return EssentialViewHolder(view)
    }

    override fun onBindViewHolder(holder: EssentialAdapter.EssentialViewHolder, position: Int) {
        val data = items[position]
        holder.iv_image.setImageResource(data.img)
        holder.tv_title.text = data.title
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class EssentialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_image: ImageView
        var tv_title: TextView

        init {
            iv_image = itemView.findViewById<ImageView>(R.id.iv_image)
            tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        }
    }
}