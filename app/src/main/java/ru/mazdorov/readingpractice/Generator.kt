package ru.mazdorov.readingpractice

import kotlin.random.Random

class Generator {
    private val allLetters = ("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЧШЩЪЫЬЭЮЯ").toCharArray()
    private val vowels = ("АЕЁИОУЫЭЮЯ").toCharArray()
    private val consonants = ("БВГДЖЗЙКЛМНПРСТФХЦШЩ").toCharArray()
    private val other = ("ЪЬ").toCharArray()
    private val exceptions = arrayOf<String>(
        "ЖЫ", "ЖЯ", "ЖЮ", "ЖЭ",
        "ЩЫ", "ЩЯ", "ЩЮ", "ЩЭ",
        "ШЫ", "ШЯ", "ШЮ", "ШЁ",
        "ЧЫ", "ЧЯ", "ЧЮ", "ЧЁ",
        "ЙЯ", "ЙЮ", "ЙЁ", "ЙУ", "ЙО", "ЙА", "ЙИ", "ЙЫ", "ЙЭ", "ЙЕ")
    private val randomizer = Randomizer()

    private fun getRandomLater(charArray: CharArray): CharSequence {
        val random = Random(randomizer.randomNumber)
        val next = random.nextInt( charArray.size)
        return charArray[next].toString()
    }

    fun generate(level: Int): CharSequence {
        return when(level){
            0-> getRandomLater(vowels).toString()
            1-> getRandomLater(consonants).toString()
            2-> getRandomLater(allLetters).toString()
            3-> getLevel_3_Text()
            4-> getLevel_4_Text()
            else -> {
                level.toString()
            }
        }
    }

    fun getLevel_3_Text(): String {
        var result = getRandomLater(consonants).toString() + getRandomLater(vowels).toString()
        if (exceptions.contains(result))
            result = getLevel_3_Text()
        return result
    }

    private fun getLevel_4_Text(): CharSequence {
        val firstPart = getLevel_3_Text()
        var secondPart: String
        do {
            secondPart = getLevel_3_Text()
        }while(firstPart[0] == secondPart[0] || firstPart[1] == secondPart[1] )

        return "$firstPart-$secondPart"
    }
}