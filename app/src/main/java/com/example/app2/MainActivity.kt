package com.example.app2


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashcard_question = findViewById<TextView>(R.id.flashcard_question)

        val flashcard_answer = findViewById<TextView>(R.id.flashcard_answer)


//        Show the answer nd hide the question
        flashcard_question.setOnClickListener{
            flashcard_question.visibility = View.INVISIBLE
            flashcard_answer.visibility = View.VISIBLE
        }

//        Show the question and hide hte answer
        flashcard_answer.setOnClickListener {
            flashcard_answer.visibility = View.INVISIBLE
            flashcard_question.visibility = View.VISIBLE
        }


        val add_card_button = findViewById<View>(R.id.add_card_button) //Variable qui nous permettra de naviguer vers la page pour ajouter un flashcard


        //Onclick listner pour ajouter des flashcard

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
            val data: Intent? = result.data

//            CodePath examples
            if (data != null) { // Check that we have data returned
                val new_card_question = data.getStringExtra("new_card_question") // 'string1' needs to match the key we used when we put the string in the Intent
                val new_card_answer_1 = data.getStringExtra("new_card_answer_1")

//                Ajout sur l'écran de la nouvelle question et de sa réponse
                flashcard_question.text = new_card_question
                flashcard_answer.text = new_card_answer_1

                // Log the value of the strings for easier debugging
                Log.i("MainActivity", "string1: $new_card_question")
                Log.i("MainActivity", "string2: $new_card_answer_1")
            } else {
                Log.i("MainActivity", "Returned null data from AddCardActivity")
            }
        }

        add_card_button.setOnClickListener{
            val intent = Intent(this, AddCardActivity::class.java)
            resultLauncher.launch(intent)

        }

//        OPTIONAL TASKS

//        Adding an Edit Button

        val edit_card_button = findViewById<ImageView>(R.id.edit_card_button)

        edit_card_button.setOnClickListener{
            val intent = Intent(this, AddCardActivity::class.java)

            intent.putExtra(
                "edit_card_question",
                flashcard_question.text
            )

            intent.putExtra(
                "edit_card_answer_1",
                flashcard_answer.text
            )
            resultLauncher.launch(intent)
        }







////        Les lignes suivantes faisaient parties des tasks optionneles d LAB I
    // Elles ont été commentées et non effacées pour de futures references



//        val flashcard_answers = findViewById<View>(R.id.flashcard_answers)

//        val flashcard_answer2 = findViewById<View>(R.id.flashcard_answer2)
//        val flashcard_answer3 = findViewById<View>(R.id.flashcard_answer3)

//        val toggleVisibilityButton = findViewById<View>(R.id.toggle_choices_visibility)
//        val toggleVisibilityIsOffButton = findViewById<View>(R.id.toggle_choices_visibility_is_off)

//        toggleVisibilityButton.setOnClickListener{
//            toggleVisibilityButton.visibility  = View.INVISIBLE
//            toggleVisibilityIsOffButton.visibility = View.VISIBLE
//            flashcard_answers.visibility = View.INVISIBLE
//        }
//
//        toggleVisibilityIsOffButton.setOnClickListener{
//            toggleVisibilityIsOffButton.visibility = View.INVISIBLE
//            toggleVisibilityButton.visibility = View.VISIBLE
//            flashcard_answers.visibility = View.VISIBLE
//        }

//        flashcard_answer.setOnClickListener {
//            flashcard_answer.setBackgroundColor(getColor(R.color.green))
//
//            flashcard_answer2.setBackgroundColor(getColor(R.color.neutral))
//            flashcard_answer3.setBackgroundColor(getColor(R.color.neutral))
//        }

//        flashcard_answer2.setOnClickListener{
//            flashcard_answer2.setBackgroundColor(getColor(R.color.red))
//
//            flashcard_answer.setBackgroundColor(getColor(R.color.neutral))
//            flashcard_answer3.setBackgroundColor(getColor(R.color.neutral))
//        }
//
//        flashcard_answer3.setOnClickListener{
//            flashcard_answer3.setBackgroundColor(getColor(R.color.red))
//
//            flashcard_answer.setBackgroundColor(getColor(R.color.neutral))
//            flashcard_answer2.setBackgroundColor(getColor(R.color.neutral))
//        }





    }
}