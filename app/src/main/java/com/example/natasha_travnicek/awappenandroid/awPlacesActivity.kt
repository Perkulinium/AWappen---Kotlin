package com.example.natasha_travnicek.awappenandroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_aw_places.*


class awPlacesActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aw_places)



       // bottom_navigation.selectedItemId = R.id.nav_search

     //  bottom_navigation.setOnNavigationItemSelectedListener(m0nNavigationItemSelectedListener)



        awPlacesRecView.layoutManager = LinearLayoutManager(this)

        awPlacesRecView.adapter = awPlacesAdapter()

    }

    fun goToOther(){
        val goTobla = Intent(this, mainActivity::class.java)
        startActivity(goTobla)
    }


}
