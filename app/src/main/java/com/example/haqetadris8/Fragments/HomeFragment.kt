package com.example.haqetadris8.Fragments


import android.arch.lifecycle.ViewModelProviders
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

        return view
    }
    //for getting strings from calculate fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txt = view.findViewById<View>(R.id.textEt) as TextView
        val model = ViewModelProviders.of(activity!!).get(Communicator::class.java)

        model.message.observe(this, object : android.arch.lifecycle.Observer<Any> {
            override fun onChanged(o: Any?) {
                txt.text = o!!.toString()
            }
        })
    //for creating items of list view based on user input
        val arrayList = ArrayList<String>()
        val lv = view.findViewById<ListView>(R.id.home_listView)
        val adapter = ArrayAdapter<String>(activity!!, android.R.layout.simple_list_item_1, arrayList)
        lv.setAdapter(adapter)
        var result :String = ""

        view.button.setOnClickListener {

            result = view.textEt.text.toString()
            arrayList.add(result)
            adapter.notifyDataSetChanged()

        }



    }
}
