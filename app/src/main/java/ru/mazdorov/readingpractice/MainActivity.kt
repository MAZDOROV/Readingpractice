package ru.mazdorov.readingpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var syllableText:TextView
    private lateinit var updateButton:Button
    private lateinit var levelsRadioGroup: RadioGroup

    private var game = Game()
    private var generator = Generator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        syllableText = findViewById(R.id.syllable_text_view)
        updateButton = findViewById(R.id.update_button)
        levelsRadioGroup = findViewById(R.id.level_radio_group)

        syllableText.setOnClickListener{
            updateText(game.level)
        }
        updateButton.setOnClickListener{
            updateText(game.level)
        }

        for (i in 0..3){
            var radioButton = RadioButton(this)
            radioButton.text = i.toString()
            radioButton.setTextColor(getColor(R.color.purple_200))
            radioButton.setOnClickListener{
                game.level = i
            }
            radioButton.setPadding(24,24,24,24 )
            levelsRadioGroup.addView(radioButton)
        }

        updateText(game.level)
    }

    private fun updateText(level:Int){
        syllableText.text = generator.generate(level)
    }



}