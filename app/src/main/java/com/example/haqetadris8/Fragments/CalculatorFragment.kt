package com.example.haqetadris8.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.haqetadris8.R
import kotlinx.android.synthetic.main.fragment_calculator.*
import kotlinx.android.synthetic.main.fragment_calculator.view.*
import net.objecthunter.exp4j.ExpressionBuilder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class CalculatorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_calculator, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //Numbers
        view.tv1.setOnClickListener { appendOnExpression(string = "1",canClear =  true) }
        view.tv2.setOnClickListener { appendOnExpression(string = "2",canClear =  true) }
        view.tv3.setOnClickListener { appendOnExpression(string = "3",canClear =  true) }
        view.tv4.setOnClickListener { appendOnExpression(string = "4",canClear =  true) }
        view.tv5.setOnClickListener { appendOnExpression(string = "5",canClear =  true) }
        view.tv6.setOnClickListener { appendOnExpression(string = "6",canClear =  true) }
        view.tv7.setOnClickListener { appendOnExpression(string = "7",canClear =  true) }
        view.tv8.setOnClickListener { appendOnExpression(string = "8",canClear =  true) }
        view.tv9.setOnClickListener { appendOnExpression(string = "9",canClear =  true) }
        view.tvZero.setOnClickListener { appendOnExpression(string = "0",canClear =  true) }
        view.tvDot.setOnClickListener { appendOnExpression(string = ".",canClear =  true) }
        //operators
        view.tvDevide.setOnClickListener { appendOnExpression(string = "/",canClear =  false) }
        view.tvMultiplication.setOnClickListener { appendOnExpression(string = "*",canClear =  false) }
        view.tvPlus.setOnClickListener { appendOnExpression(string = "+",canClear =  false) }
        view.tvMinus.setOnClickListener { appendOnExpression(string = "-",canClear =  false) }
        view.tvOpenP.setOnClickListener { appendOnExpression(string = "(",canClear =  false) }
        view.tvCloseP.setOnClickListener { appendOnExpression(string = ")",canClear =  false) }

        tvClear.setOnClickListener {
            view.tvExpression.text = ""
            view.tvResult.text = ""
        }
        view.tvDelete.setOnClickListener{
            val string = view.tvExpression.text.toString()
            if(string.isNotEmpty()){
                view.tvExpression.text = string.substring(0, string.length-1)
            }
            view.tvResult.text = ""
        }
        view.tvEquals.setOnClickListener{
            try {
                val expression = ExpressionBuilder(view.tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    view.tvResult.text = longResult.toString()
                else
                    view.tvResult.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception", "message : " + e.message)
            }

        }


    }

    fun appendOnExpression( string: String, canClear : Boolean){

        if(view!!.tvResult.text.isNotEmpty()){
            view!!.tvResult.text = ""
        }

        if (canClear){
            view!!.tvResult.text = ""
            view!!.tvExpression.append(string)
        }else{
            view!!.tvExpression.append(view!!.tvResult!!.text)
            view!!.tvExpression.append(string)
            view!!.tvResult.text = ""
        }
    }








}
