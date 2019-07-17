package com.example.haqetadris8.Fragments


import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.haqetadris8.Communicator
import com.example.haqetadris8.MainActivity
import com.example.haqetadris8.R
import kotlinx.android.synthetic.main.fragment_calculate.view.*
import kotlinx.android.synthetic.main.fragment_pdf.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        val mypref = activity!!.getSharedPreferences("mypref" , Context.MODE_PRIVATE)
        val data = mypref.getString("CourseData",null)?.split("|")

        data?:let{
            Toast.makeText(context,R.string.emptyList,Toast.LENGTH_SHORT).show()
        }

        data?.let {
            val lv = view.findViewById<ListView>(R.id.home_listView)
            val adapter = ArrayAdapter<String>(activity!!, android.R.layout.simple_list_item_1, it)
            lv.adapter = adapter

        }

        return view
    }


}

