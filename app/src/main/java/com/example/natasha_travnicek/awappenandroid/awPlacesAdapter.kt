package com.example.natasha_travnicek.awappenandroid

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.aw_places_layout.view.*
import java.io.Serializable

class awPlacesAdapter(var place: MutableList<firebase>, val clickplaceListener: (Int) -> Unit) : RecyclerView.Adapter<awPlacesAdapter.awPlacesViewHolder>(){

//    , val clickpersonListener: (Int) -> Unit) :

    fun letsUpdateStuff(thenewPlace: MutableList<firebase>)
    {
        place = thenewPlace
        notifyDataSetChanged()
    }

    //Viewholder = row (UITableviewCell)
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

        //holder.awplaceTextView.text = place.get(rownumber).toString()
        holder.awPlaceTextView1.text = place.get(rownumber).name

        // holder.awPlaceTextView1.text = "Hello" + rownumber.toSt ring()
     //   holder.awPlaceTextView1.text = place.get(rownumber).name

     //   holder.personname.text = people.get(rownumber)
        holder.firstname.text = place.get(rownumber).fbKey


    }

    class awPlacesViewHolder (view: View) : RecyclerView.ViewHolder(view){

        lateinit var theAdapter : awPlacesAdapter

        val firstname = view.awplaceTW


        init {
      view.setOnClickListener(){


       //   Toast.makeText(view.context, "Rad: " + awPlaceTextView1, Toast.LENGTH_SHORT).show()
         // Toast.makeText(view.context, "KLICK PÅ RAD " + theAdapter.place.get(adapterPosition), Toast.LENGTH_LONG).show()


          val intent = Intent(view.context, MapAndDetailsMapsActivity::class.java)

       //     Log.i("pia8", "${theAdapter.place.get(adapterPosition)}")
       //   Log.i("pia8", "${theAdapter.place.get(adapterPosition).longitude}")



          intent.putExtra("awplace", theAdapter.place.get(adapterPosition))




         // intent.putExtra("awPlaceTextView1", theAdapter.place.get(adapterPosition))
          //goDetailIntent.putExtra("person", theadapter.people.get(adapterPosition))


          Log.i("pia8", "${awPlaceTextView1.text}")

           view.context.startActivity(intent)

      }

        }
    val awPlaceTextView1 = view.awplaceTW



    }
}