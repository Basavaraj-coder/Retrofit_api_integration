package com.example.myapi

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val productList :List<Product>):
    RecyclerView.Adapter<MyAdapter.ViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val i = LayoutInflater.from(context).inflate(R.layout.singlerow,parent,false)
        return ViewHolder(i)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        val currentData = productList[position]
        holder.title.text = currentData.title
        holder.description.text = currentData.description
        holder.price.text = currentData.price.toString()

        //to show image from url
        Picasso.get().load(currentData.thumbnail).into(holder.img)


    }

    override fun getItemCount(): Int {
        return productList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var title:TextView
        lateinit var img :ShapeableImageView
        lateinit var description:TextView
        lateinit var price :TextView

        init {
            title = itemView.findViewById(R.id.textviewRc)
            img = itemView.findViewById(R.id.imageRc)
            description = itemView.findViewById(R.id.productDescriptionRc)
            price = itemView.findViewById(R.id.priceRc)
        }
    }

}