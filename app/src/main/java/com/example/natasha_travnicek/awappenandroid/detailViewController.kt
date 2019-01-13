package com.example.natasha_travnicek.awappenandroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_detail_view_controller.*

class detailViewController : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_view_controller)


        textTextView.text = intent.getStringExtra("awPlaceTextView1")


    }

    fun toMapTemp(view: View){

        val goToOtherIntent = Intent(this, MapAndDetailsMapsActivity::class.java)

        startActivity(goToOtherIntent)



    }
}
