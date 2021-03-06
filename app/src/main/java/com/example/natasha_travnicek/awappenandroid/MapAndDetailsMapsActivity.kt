package com.example.natasha_travnicek.awappenandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_map_and_details_maps.*

class MapAndDetailsMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    var awplace = firebase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_and_details_maps)

        awplace = intent.getSerializableExtra("awplace") as firebase

        awplaceName.text = awplace.Name
        awplaceAdress.text = awplace.Address
        awplaceOpeningHour.text = awplace.Openinghours
        awplaceWebsite.text = awplace.Webbsite

        setCategoryImage()

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    fun setCategoryImage() {

        var categories = awplace.getCatgories()

        /*
        ORDER of imagechecks
        ______________
        Event
        Activity
        Nightclub
        Bowling
        Restaurant
        Bar
        ______________
         */


        if(categories.contains("Event")) {
            categoryImage.setImageResource(R.drawable.musicphoto)
        } else if (categories.contains("Activity")) {
            categoryImage.setImageResource(R.drawable.pooltable)
        } else if (categories.contains("Nightclub")) {
            categoryImage.setImageResource(R.drawable.discoball)
        } else if (categories.contains("Bowling")) {
            categoryImage.setImageResource(R.drawable.activityphotobowling)
        } else if (categories.contains("Restaurant")) {
            categoryImage.setImageResource(R.drawable.foodphoto)
        } else if (categories.contains("Bar")) {
            categoryImage.setImageResource(R.drawable.beer)
        }


        if(awplace.Name == "BrewDog Bar") {
            categoryImage.setImageResource(R.drawable.beer)
        }


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


            var showplace = LatLng(awplace.Latitude as Double, awplace.Longitude as Double)
            //var showplace = LatLng(latitudeA!!, longitudeB!!)
            mMap.addMarker(MarkerOptions().position(showplace).title(awplace.Name))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(showplace, 18f))}

}
