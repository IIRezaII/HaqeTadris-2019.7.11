package com.example.haqetadris8

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentTransaction
import com.example.haqetadris8.Fragments.*

class MainActivity : AppCompatActivity() {


    lateinit var homeFragment: HomeFragment
    lateinit var calculationFragment: CalculateFragment
    lateinit var pdfFragment: PdfFragment
    lateinit var calculatorFragment: CalculatorFragment
    lateinit var shareFragment: ShareFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.btm_nav)

        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()



        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId){


                R.id.home-> {

                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.share-> {

                    shareFragment = ShareFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, shareFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.calculation-> {

                calculationFragment = CalculateFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, calculationFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.pdf-> {

                pdfFragment = PdfFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, pdfFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.calculator-> {

                    calculatorFragment = CalculatorFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, calculatorFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }



            }

            true
        }



    }
}
