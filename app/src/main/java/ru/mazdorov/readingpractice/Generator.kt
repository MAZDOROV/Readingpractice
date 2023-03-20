package ru.mazdorov.readingpractice

import kotlin.random.Random

class Generator {

    private val allLetters = ("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЧШЩЪЫЬЭЮЯ").toCharArray()
    private val vowels = ("АЕЁИОУЫЭЮЯ").toCharArray()
    private val consonants = ("БВГДЖЗЙКЛМНПРСТФХЦШЩ").toCharArray()
    private val other = ("ЪЬ").toCharArray()
    private val exceptions = arrayOf<String>("ЖЫ", "ШЫ", "ЩЯ", "ЧЯ", "ЩЮ", "ЧЮ", "ЙЯ", "ЙЮ", "ЙЁ", "ЙУ", "ЙО", "ЙА","ЙИ","ЙЫ","ЙЭ","ЙЕ")

    private var _randomNumber:Long = 0
    private val randomNumber:Long
        get() {
            val newValue = System.currentTimeMillis()
            if(_randomNumber == newValue)
                _randomNumber =  newValue + 1
            else
                _randomNumber = newValue
            return  _randomNumber}

    private fun getOneRandom(charArray: CharArray): CharSequence {
        val random = Random(randomNumber)
        val next = random.nextInt( charArray.size)
        return charArray[next].toString()
    }

    fun generate(level: Int): CharSequence {

        return when(level){
            0-> getOneRandom(vowels).toString()
            1-> getOneRandom(consonants).toString()
            2-> getOneRandom(allLetters).toString()
            3-> getLevel_3_Text()
            4-> getLevel_4_Text()
            else -> {
                level.toString()
            }
        }
    }

    fun getLevel_3_Text(): String
    {
        var result = getOneRandom(consonants).toString() + getOneRandom(vowels).toString()
        if (exceptions.contains(result))
            result = getLevel_3_Text()
        return result
    }

    private fun getLevel_4_Text(): CharSequence {
        return getLevel_3_Text() + getLevel_3_Text()
    }
}