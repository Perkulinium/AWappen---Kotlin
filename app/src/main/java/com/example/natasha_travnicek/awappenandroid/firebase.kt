package com.example.natasha_travnicek.awappenandroid

data class firebase(var fbKey : String? = null,
                    var name : String? = "",
                    var longitude : Int? = null,
                    var latitude : Int? = null,
                    var openinghours : String? = "",
                    var address : String? = "",
                    var website : String? = "",
                    var restaurant : Boolean? = false,
                    var activity : Boolean? = false,
                    var nightclub : Boolean? = false,
                    var event : Boolean? = false
                    ) {


}