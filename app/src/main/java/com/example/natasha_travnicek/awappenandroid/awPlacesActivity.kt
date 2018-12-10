package com.example.natasha_travnicek.awappenandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_aw_places.*

class awPlacesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aw_places)

        awPlacesRecView.layoutManager = LinearLayoutManager(this)

        awPlacesRecView.adapter = awPlacesAdapter()

    }



}
