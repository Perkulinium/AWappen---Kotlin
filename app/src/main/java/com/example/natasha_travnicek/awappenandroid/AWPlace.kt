package com.example.natasha_travnicek.awappenandroid

data class AWPlace(

    var activity : Boolean? = false,
    var bar : Boolean? = false,
    var event : Boolean? = false,
    var nightclub : Boolean? = false,
    var restaurant : Boolean? = false,
    var bowling : Boolean? = false,
    var weekly : Boolean? = false,

    var name : String? = "",
    var webbsite : String? = "",
    var longitude : String? = "",
    var latitude : String? = "",
    var openingHours : String? = "",
    var adress : String? = ""




) {
    var categories = mutableListOf<String>()




    fun setInformation() {


        //Gets information from firebase usage here


    }

    fun getCategoriesAsArray() : List<String> {
        categories.clear()

        if(activity!!) {
            categories.add("Activity")
        }
        if(bar!!) {
            categories.add("Bar")
        }
        if(event!!) {
            categories.add("Event")
        }
        if(nightclub!!) {
            categories.add("Nightclub")
        }
        if(restaurant!!) {
            categories.add("Restaurant")
        }
        if(bowling!!) {
            categories.add("Bowling")
        }


        return categories

    }



}