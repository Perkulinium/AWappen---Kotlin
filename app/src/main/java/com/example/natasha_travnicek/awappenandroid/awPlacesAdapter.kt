package com.example.natasha_travnicek.awappenandroid

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.aw_places_layout.view.*

class awPlacesAdapter(var place: MutableList<firebase>, val clickplaceListener: (Int) -> Unit) : RecyclerView.Adapter<awPlacesAdapter.awPlacesViewHolder>(){


    fun letsUpdateStuff(thenewPlace: MutableList<firebase>)
    {
        place = thenewPlace
        notifyDataSetChanged()
    }

    //create a row
    override fun onCreateViewHolder(parent: ViewGroup, rownumber: Int): awPlacesAdapter.awPlacesViewHolder {
        var theHolder = awPlacesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.aw_places_layout, parent, false))
        theHolder.theAdapter = this
        return theHolder

    }

    override fun getItemCount(): Int {
        return place.size
    }

    //Add content to row
    override fun onBindViewHolder(holder: awPlacesAdapter.awPlacesViewHolder, rownumber: Int) {

        holder.firstname.text = place.get(rownumber).Name

    }

    class awPlacesViewHolder (view: View) : RecyclerView.ViewHolder(view){

        lateinit var theAdapter : awPlacesAdapter

        val firstname = view.awplaceTW

        init {
      view.setOnClickListener(){

          val intent = Intent(view.context, MapAndDetailsMapsActivity::class.java)
          intent.putExtra("awplace", theAdapter.place.get(adapterPosition))
          Log.i("pia8", "${awPlaceTextView1.text}")

           view.context.startActivity(intent)
      }
}
    val awPlaceTextView1 = view.awplaceTW

    }
}