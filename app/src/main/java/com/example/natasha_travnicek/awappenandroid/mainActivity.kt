package com.example.natasha_travnicek.awappenandroid

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class mainActivity : AppCompatActivity(), HomeFragment.OnFragmentInteractionListener, SearchFragment.OnFragmentInteractionListener{


    private val m0nNavigationItemSelectedListener =  BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId) {

            R.id.Home_Container -> {
                Log.d("TAG", "Hem")

               replaceFragmentHome(HomeFragment())

                return@OnNavigationItemSelectedListener true
            }

        R.id.Search_Container -> {
            Log.d("TAG", "sök")

            replaceFragmentSearch(SearchFragment())

              return@OnNavigationItemSelectedListener true

        }
        R.id.Favorites_Container -> {
            Log.d("TAG", "sök")

            replaceFragmentFavorites(FavoritesFragment())

            return@OnNavigationItemSelectedListener true
        }
    }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

bottom_navigation.setOnNavigationItemSelectedListener(m0nNavigationItemSelectedListener)

      replaceFragmentHome(HomeFragment())

    }





    private fun replaceFragmentHome(fragment: Fragment){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_Container, HomeFragment())
        transaction.commit()
    }


    private fun replaceFragmentSearch(fragment: Fragment){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_Container, SearchFragment())
        //  transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun replaceFragmentFavorites(fragment : Fragment){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_Container, FavoritesFragment())
        //transaction.replace(R.id.fragment_Container, FavoriteFragment())
        transaction.commit()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
