package ru.mazdorov.readingpractice

import kotlin.random.Random

public class Generator {

    private val allLetters = ("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЧШЩЪЫЬЭЮЯ").toCharArray()
    private val vowels = ("АЕЁИОУЫЭЮЯ").toCharArray()
    private val consonants = ("БВГДЖЗЙКЛМНПРСТФХЦШЩ").toCharArray()
    private val other = ("ЪЬ").toCharArray()

    private val exceptions = arrayOf<String>("ЩЯ", "ЧЯ", "ЙЯ", "ЙЮ", "ЙЁ")

    private fun getOneRandom(charArray: CharArray): CharSequence? {
        var random = Random(System.currentTimeMillis())
        var next = random.nextInt( charArray.size)
        return charArray[next].toString()
    }

    fun generate(level: Int): CharSequence? {

        var text = when(level){
            0-> getOneRandom(vowels).toString()
            1-> getOneRandom(consonants).toString()
            2-> getOneRandom(allLetters).toString()
            3-> getOneRandom(consonants).toString() + getOneRandom(vowels).toString()
            else -> {
                "You win!"
            }
        }
        return text
    }
}