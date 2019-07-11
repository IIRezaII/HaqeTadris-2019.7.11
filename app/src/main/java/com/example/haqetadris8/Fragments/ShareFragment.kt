package com.example.haqetadris8.Fragments


import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.haqetadris8.Communicator

import com.example.haqetadris8.R
import kotlinx.android.synthetic.main.fragment_pdf.view.*
import kotlinx.android.synthetic.main.fragment_share.*
import kotlinx.android.synthetic.main.fragment_share.view.*
import java.util.zip.Inflater

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ShareFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_share, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var txt : String = ""

        val model= ViewModelProviders.of(activity!!).get(Communicator::class.java)

        model.message.observe(this, object :  android.arch.lifecycle.Observer<Any> {
            override fun onChanged(o: Any?) {
                txt = o!!.toString()
            }
        })



        view.shareButton.setOnClickListener {


            if (txt.isNullOrEmpty()){

                Toast.makeText(activity, R.string.emptyUnitText, Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }else {
                val myIntent = Intent(Intent.ACTION_SEND)
                myIntent.type = "text/plain"
                val shareSubject = "Haqe Tadris:"
                val shareBody = txt
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                startActivity(Intent.createChooser(myIntent, "Share with"))
            }
        }
    }


}
