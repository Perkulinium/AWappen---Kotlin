package com.example.natasha_travnicek.awappenandroid

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.aw_places_layout.view.*

class awPlacesAdapter : RecyclerView.Adapter<awPlacesAdapter.awPlacesViewHolder>(){

    //Viewholder = row (UITableviewCell)
    //create a row
    override fun onCreateViewHolder(parent: ViewGroup, rownumber: Int): awPlacesAdapter.awPlacesViewHolder {
        return awPlacesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.aw_places_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return 6
    }

    //Add content to row
    override fun onBindViewHolder(holder: awPlacesAdapter.awPlacesViewHolder, rownumber: Int) {
        holder.awPlaceTextView1.text = "Hello" + rownumber.toString()

    }

    class awPlacesViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val awPlaceTextView1 = view.awplaceTextView



    }
}