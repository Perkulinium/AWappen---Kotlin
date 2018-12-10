package com.example.natasha_travnicek.awappenandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class mainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun toAWPlaces(view: View){

        val goToOtherIntent = Intent(this, awPlacesActivity::class.java)

        startActivity(goToOtherIntent)



    }


}
