package com.example.natasha_travnicek.awappenandroid

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.favorites_recview_layout.view.*
import kotlinx.android.synthetic.main.fragment_home.*

class favoritesAdapter : RecyclerView.Adapter<favoritesAdapter.favoritesViewHolder>(){

    //Viewholder = row (UITableviewCell)
    //create a row
    override fun onCreateViewHolder(parent: ViewGroup, rownumber: Int): favoritesAdapter.favoritesViewHolder {
        return favoritesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.favorites_recview_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return 6
    }

    //Add content to row
    override fun onBindViewHolder(holder: favoritesViewHolder, rownumber: Int) {
       holder.favorites_TextView.text = "Hello" + rownumber.toString()


    }

    class favoritesViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val favorites_TextView = view.favoritesTextView


    }



}