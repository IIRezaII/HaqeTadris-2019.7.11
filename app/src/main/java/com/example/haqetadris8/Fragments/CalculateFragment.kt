package com.example.haqetadris8.Fragments


import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.haqetadris8.Communicator

import com.example.haqetadris8.R
import com.example.haqetadris8.StartFunction
import kotlinx.android.synthetic.main.fragment_calculate.*
import kotlinx.android.synthetic.main.fragment_calculate.view.*
import kotlinx.android.synthetic.main.fragment_calculate.view.tvCourseName

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class CalculateFragment : Fragment() {


    private var model: Communicator?=null

    //for sharedPrefernces
    lateinit var editTextCourseName :EditText
    lateinit var editTextcourseCoefficient :EditText



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calculate, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = ViewModelProviders.of(activity!!).get(Communicator::class.java)

        val CourseName = view.findViewById<View>(R.id.tvCourseName) as EditText
        editTextCourseName = view.findViewById(R.id.tvCourseName)
        editTextcourseCoefficient = view.findViewById(R.id.tvResult)

            view.button.setOnClickListener {

                if (view.tvStuNumber.text.isNullOrEmpty() || view.tvUnit.text.isNullOrEmpty()) {

                    Toast.makeText(activity, R.string.emptyUnitText, Toast.LENGTH_SHORT).show()
                    return@setOnClickListener

                }


                val stuNumText = view.tvStuNumber.text.toString().toInt()
                val unitText = view.tvUnit.text.toString().toInt()


                if (view.proRadio.isChecked) {

                    val finalValue: Double = StartFunction().associatesStart(stuNumText, unitText)
                    view.findViewById<TextView>(R.id.tvResult).text = finalValue.toString()

                }

                if (view.genRadio.isChecked) {

                    val finalValue: Double = StartFunction().generalStart(stuNumText, unitText)
                    view.findViewById<TextView>(R.id.tvResult).text = finalValue.toString()

                }

                if (view.masterRadio.isChecked) {

                    val finalValue: Double = StartFunction().masterStart(stuNumText, unitText)
                    view.findViewById<TextView>(R.id.tvResult).text = finalValue.toString()

                }

                //add persian support

                model!!.setMsgCommunicator("نام درس : " + CourseName.text.toString()  + "\n" +
                                 "تعداد دانش جویان : "  + tvStuNumber.text.toString() + "\n" +
                                          "واحد درس : " + tvUnit.text.toString()      + "\n" +
                                 "ضریب حق تدریس شما : " + tvResult.text.toString()    + "\n"
                                          )

                saveData()



            }

    }
    /*private fun retriveData(){
        val mypref = activity!!.getSharedPreferences("mypref" , Context.MODE_PRIVATE)

        val courseName = mypref.getString("CourseName", "")
        val CourseCoefficient = mypref.getString("CourseCoefficient", "")
    }*/

    private fun saveData() {
        if (editTextCourseName.text.isEmpty()){

            editTextCourseName.error = "لطفا نام درس را وارد کنید"
            return
        }
        if (editTextcourseCoefficient.text.isEmpty()){

            editTextCourseName.error = "لطفا ضریب را محاسبه کنید"
            return
        }
        val mypref = activity!!.getSharedPreferences("mypref" , Context.MODE_PRIVATE)

        val editor = mypref.edit()

        editor.putString("CourseName", editTextCourseName.text.toString())
        editor.putString("CourseCoefficient", editTextCourseName.text.toString())


        editor.apply()

    }


}










