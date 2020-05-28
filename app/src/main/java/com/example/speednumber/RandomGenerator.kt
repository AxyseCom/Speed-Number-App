package com.example.speednumber

class RandomGenerator(val a: Int, val b: Int) {

    var asd = 11

    fun getLeftNumber() : Int {
        val random = (a..b).random()
        return random
    }

    fun getRightNumber() : Int {
        val random = (a..b).random()
        return random
    }

    fun getFalseNumber() : Int{
        val random = (a..b).random()
        return random
    }

}