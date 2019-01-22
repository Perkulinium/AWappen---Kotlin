package com.example.natasha_travnicek.awappenandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_map_and_details_maps.*
import kotlin.math.log

class MapAndDetailsMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    var awplace = firebase()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_and_details_maps)

        awplace = intent.getSerializableExtra("awplace") as firebase


        awplaceName.text = awplace.fbKey
        awplaceAdress.text = awplace.Address
        awplaceOpeningHour.text = awplace.Openinghours
        awplaceWebsite.text = awplace.Webbsite




     //   Log.i("pi8", "details : " + awplace.fbKey)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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




       /* // if place not found:
       var latitudeA = awplace.Latitude
       var longitudeB = awplace.Longitude
        if (latitudeA == null || longitudeB == null){
            var showplace = LatLng(55.60587, 13.00073)
            mMap.addMarker(MarkerOptions().position(showplace).title("Place not found. Marker in Malmö."))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(showplace, 18f))

        }
        else {*/
            var showplace = LatLng(awplace.Latitude as Double, awplace.Longitude as Double)
            //var showplace = LatLng(latitudeA!!, longitudeB!!)
            mMap.addMarker(MarkerOptions().position(showplace).title(awplace.name as String))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(showplace, 18f))}
        //}
}
