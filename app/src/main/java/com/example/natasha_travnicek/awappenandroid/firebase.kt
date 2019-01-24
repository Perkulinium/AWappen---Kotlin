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
                    var Event : Boolean? = false,
                    var Weekly : Boolean? = false
                    ) : Serializable {


}