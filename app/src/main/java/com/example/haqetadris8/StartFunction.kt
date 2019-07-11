package com.example.haqetadris8

class StartFunction {

    fun associatesStart(stuNumber : Int, unit: Int) : Double {

        val newUnit :Double

        while (stuNumber in 20..40) {
            newUnit = unit.toDouble()
            return newUnit
        }

        if (stuNumber > 40){
            newUnit = Calculate().associatesDegreeMoreThan40(unit, stuNumber)
        }
        else {
            newUnit = Calculate().associatesDegreeUnder20(unit, stuNumber)
        }

        return newUnit
    }


    fun generalStart(stuNumber : Int, unit: Int) : Double {

        val newUnit :Double

        while (stuNumber in 25..50) {
            newUnit = unit.toDouble()
            return newUnit
        }

        if (stuNumber > 50){
            newUnit = Calculate().generalMoreThan50(unit, stuNumber)
        }
        else {
            newUnit = Calculate().generalUnder25(unit, stuNumber)
        }

        return newUnit
    }

    fun masterStart(stuNumber : Int, unit: Int) : Double {

        val newUnit :Double

        while (stuNumber in 7..25) {
            newUnit = unit.toDouble()
            return newUnit
        }

        if (stuNumber > 25){
            newUnit = Calculate().masterDegreeMoreThan25(unit, stuNumber)
        }
        else {
            newUnit = Calculate().masterDegreeUnder7(unit, stuNumber)
        }

        return newUnit
    }


}