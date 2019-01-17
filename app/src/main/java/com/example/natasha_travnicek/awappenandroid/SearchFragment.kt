package com.example.natasha_travnicek.awappenandroid

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SearchFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SearchFragment : Fragment() {


    val TAG = "awAppen"
    var place = mutableListOf<firebase>()

    var searchResult = mutableListOf<firebase>()

    lateinit var theAdapter: awPlacesAdapter

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: SearchFragment.OnFragmentInteractionListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val theLayout = inflater.inflate(R.layout.fragment_search, container, false)

        theLayout.searchBox.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.i("pi8", newText)

                searchResult.clear()


                for(places in place) {


                    if(places.fbKey!!.contains(newText!!, ignoreCase = true)) {
                        searchResult.add(places)
                    }

                    theAdapter.letsUpdateStuff(searchResult)

                }


                return false
            }

        })




        // Inflate the layout for this fragment
        return theLayout


    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)





       // place.add(Place("3_test", "Hej", "aw"))


//        place.add(Place("dsda", "Då"))




        recView.layoutManager = LinearLayoutManager(context)
        theAdapter = awPlacesAdapter(place) {
            rownumberClicked ->
            Log.i(TAG, "Vi klickade på raden $rownumberClicked")
            loadPlaces()
        }
        recView.adapter = theAdapter
        loadPlaces()




    }


    fun loadPlaces() {


        val database = FirebaseDatabase.getInstance()
        val placeRef = database.reference

        val test = placeRef.child("")
        //val placeref2 = placeRef.child("Longitude")

        val getPlaceListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {

              for (currentPlace in dataSnapshot.children) {
                    val thePlace = currentPlace.getValue(firebase::class.java)



                 thePlace?.fbKey = currentPlace.key


                    Log.i(TAG, "Loop person ${thePlace!!.fbKey}")
                  Log.i(TAG, "Loop person ${thePlace!!.longitude}")

                  //Log.i("pia8", "${thePlace.latitude}")
                  //Log.i("pia8", "${thePlace.longitude}")

                  place.add(thePlace)

              }
                theAdapter.letsUpdateStuff(place)

            }




            override fun onCancelled(databaseError: DatabaseError) {

                Log.w(TAG, "Loadpost: onCancelled", databaseError.toException())


            }

        }

       // placeRef.addListenerForSingleValueEvent(getPlaceListener)
          placeRef.addListenerForSingleValueEvent(getPlaceListener)
    }


    fun savePerson(view : View)
    {

        val database = FirebaseDatabase.getInstance()

        val placeRef = database.getReference("3_test")

       // val PlaceToSave = firebase()

        //PlaceToSave.name = awplaceTextView.text.toString()

       // placeRef.push().setValue(PlaceToSave)
       // PlaceToSave.saveMe()
        loadPlaces()


    }
/*
    data class Place(
        var fbKey : String? = null,

        var name : String? = "",
        // var age : Int? = null

    var jobb : String? = ""


    )
*/

}





