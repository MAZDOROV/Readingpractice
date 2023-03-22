package ru.mazdorov.readingpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.children
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private lateinit var syllableText:TextView
    private lateinit var updateButton:Button
    private lateinit var levelsRadioGroup: RadioGroup

    private var game = Game()
    private var generator = Generator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        game.level.observe(this, Observer { newValue ->
            updateText(newValue)
        })

        syllableText = findViewById(R.id.syllable_text_view)
        updateButton = findViewById(R.id.update_button)
        levelsRadioGroup = findViewById(R.id.level_radio_group)

        syllableText.setOnClickListener{
            updateText(game.level.value)
        }
        updateButton.setOnClickListener{
            updateText(game.level.value)
        }

        for (i in 0..5){
            val radioButton = RadioButton(this)
            radioButton.text = i.toString()
            radioButton.setTextColor(getColor(R.color.purple_200))
            radioButton.setPadding(24,24,24,24 )
            levelsRadioGroup.addView(radioButton)
        }
        levelsRadioGroup.setOnCheckedChangeListener{ buttonView, isChackad ->
            val id = levelsRadioGroup.checkedRadioButtonId // Get the id of the selected RadioButton
            val index = levelsRadioGroup.indexOfChild(levelsRadioGroup.findViewById(id)) // Get the index of the selected RadioButton
            game.level.value = index
        }
        levelsRadioGroup.check(levelsRadioGroup.children.last().id)
    }

    private fun updateText(level:Int?){
        syllableText.text = generator.generate(level)
    }
}