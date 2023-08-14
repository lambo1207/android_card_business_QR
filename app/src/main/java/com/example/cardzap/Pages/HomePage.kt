package com.example.cardzap.Pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cardzap.Pages.Fragments.ContactsFragment
import com.example.cardzap.Pages.Fragments.MyeCardsFragment
import com.example.cardzap.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePage : AppCompatActivity() {

    private val myeCardsFragments = MyeCardsFragment()
    private val contactsFragments = ContactsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        getSupportActionBar()?.show()


        replaceFragment(myeCardsFragments)

        var bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_MyeCard -> replaceFragment(myeCardsFragments)
                R.id.ic_Contacts -> replaceFragment(contactsFragments)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}