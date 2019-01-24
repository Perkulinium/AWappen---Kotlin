package com.example.natasha_travnicek.awappenandroid

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_map_and_details_maps.*
import kotlinx.android.synthetic.main.fragment_home.*

//import android.widget.Button;



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    //hämta aw ställe från facebook
    var weekly_place : firebase? = null
    var place = mutableListOf<firebase>()


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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
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


     //Ladda alla ställen från firebase
    fun loadPlaces() {


        val database = FirebaseDatabase.getInstance()
        val placeRef = database.reference

        //val test = placeRef.child("")
        //val placeref2 = placeRef.child("Longitude")

        val getPlaceListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (currentPlace in dataSnapshot.children) {
                    val thePlace = currentPlace.getValue(firebase::class.java)

                    thePlace?.Name = currentPlace.key
                    thePlace?.Openinghours = currentPlace.child("Opening hours").value.toString()

                    Log.i("awapplog", "CHECK PLACE "+thePlace!!.Name)
                    if(thePlace!!.Weekly == true)
                    {
                        Log.i("awapplog", "FOUND PLACE "+thePlace!!.Name)
                        weekly_place = thePlace

                        //home_weekly_button.text = weekly_place!!.fbKey
                        textView3.text = weekly_place!!.Name
                    }




                }

            }



            override fun onCancelled(databaseError: DatabaseError) {


            }

        }

        // placeRef.addListenerForSingleValueEvent(getPlaceListener)
        placeRef.addListenerForSingleValueEvent(getPlaceListener)
    }



    override fun onStart() {
        super.onStart()

        home_weekly_button.setOnClickListener {

            if(weekly_place != null)
            {
                val intent = Intent(this.context, MapAndDetailsMapsActivity::class.java)
                intent.putExtra("awplace", weekly_place)  //vilket är veckans aw
                startActivity(intent)
            }

        }

        loadPlaces()

    }

      //  home_weekly_button.text = "abc"                 //vad heter veckans ställe



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
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
