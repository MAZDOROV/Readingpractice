package ru.mazdorov.readingpractice

class Randomizer {
    private var _randomNumber:Long = 0
    val randomNumber:Long
        get() {
            val newValue = System.currentTimeMillis()
            if(_randomNumber == newValue)
                _randomNumber =  newValue + 1
            else
                _randomNumber = newValue
            return  _randomNumber}
}