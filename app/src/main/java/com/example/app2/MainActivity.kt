package com.example.app2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashcard_question = findViewById<View>(R.id.flashcard_question)

        val flashcard_answers = findViewById<View>(R.id.flashcard_answers)

        val flashcard_answer = findViewById<View>(R.id.flashcard_answer)
        val flashcard_answer2 = findViewById<View>(R.id.flashcard_answer2)
        val flashcard_answer3 = findViewById<View>(R.id.flashcard_answer3)

        val toggleVisibilityButton = findViewById<View>(R.id.toggle_choices_visibility)

        toggleVisibilityButton.setOnClickListener{
            if (flashcard_answers.visibility == View.VISIBLE)
                flashcard_answers.visibility = View.INVISIBLE
            else
                flashcard_answers.visibility = View.VISIBLE

        }


        flashcard_answer.setOnClickListener {
            flashcard_answer.setBackgroundColor(getColor(R.color.green))

            flashcard_answer2.setBackgroundColor(getColor(R.color.neutral))
            flashcard_answer3.setBackgroundColor(getColor(R.color.neutral))
        }

        flashcard_answer2.setOnClickListener{
            flashcard_answer2.setBackgroundColor(getColor(R.color.red))

            flashcard_answer.setBackgroundColor(getColor(R.color.neutral))
            flashcard_answer3.setBackgroundColor(getColor(R.color.neutral))
        }

        flashcard_answer3.setOnClickListener{
            flashcard_answer3.setBackgroundColor(getColor(R.color.red))

            flashcard_answer.setBackgroundColor(getColor(R.color.neutral))
            flashcard_answer2.setBackgroundColor(getColor(R.color.neutral))
        }


//        flashcard_question.setOnClickListener {
//            flashcard_question.visibility = View.INVISIBLE
//            flashcard_answer.visibility = View.VISIBLE
//        }
//
//        flashcard_answer.setOnClickListener{
//            flashcard_answer.visibility = View.INVISIBLE
//            flashcard_question.visibility = View.VISIBLE
//        }

    }
}