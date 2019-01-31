package com.example.natasha_travnicek.awappenandroid

import java.io.Serializable

data class firebase (var Name : String? = null,
                    var Longitude : Double? = null,
                    var Latitude : Double? = null,
                    var Openinghours : String? = "",
                    var Address : String? = "",
                    var Webbsite : String? = "",
                    var Restaurant : Boolean? = false,
                    var Activity : Boolean? = false,
                    var Nightclub : Boolean? = false,
                    var Bar : Boolean? = false,
                    var Event : Boolean? = false,
                    var Weekly : Boolean? = false
                    ) : Serializable {



    fun getCatgories() : MutableList<String> {

        var categories = mutableListOf<String>()


        if (Bar == true) {
            categories.add("Bar")
        }
        if (Event == true) {
            categories.add("Event")
        }

        if (Restaurant == true) {
            categories.add("Restaurant")
        }

        if (Activity == true) {
            categories.add("Activity")
        }

        if (Nightclub == true) {
            categories.add("Nightclub")
        }


        return categories

    }





}