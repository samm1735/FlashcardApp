package com.example.app2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts


class AddCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)


//        Buttons
        val cancel_card_button = findViewById<View>(R.id.cancel_card_button)
        val save_card_button = findViewById<View>(R.id.save_card_button)

//        Inputs

        val add_card_answer1_field = findViewById<EditText>(R.id.add_card_answer1_field)
        val add_card_question_field = findViewById<EditText>(R.id.add_card_question_field)


//        Intent's variables
        val edit_card_question = intent.getStringExtra("edit_card_question")
        val edit_card_answer_1 = intent.getStringExtra("edit_card_answer_1")


//        Setting the text on the textfields if the user is trying to edit

        if (edit_card_question != null){
            add_card_question_field.setText(edit_card_question)
            add_card_answer1_field.setText(edit_card_answer_1)
        }





        cancel_card_button.setOnClickListener{
            val cancelIntent = Intent(this, MainActivity::class.java)
            startActivity(cancelIntent)
            finish()
        }

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            val data: Intent? = result.data
        }

        save_card_button.setOnClickListener{
//            val saveCardIntent = Intent(this, MainActivity::class.java)

            if(add_card_question_field.text.toString().isEmpty() || add_card_answer1_field.text.toString().isEmpty()){
//                If either of the EditText views aren't populated

                Toast.makeText(applicationContext, "Fields can't be empty", Toast.LENGTH_SHORT).show()
            }
            else{
                val saveCardIntent = Intent()


                saveCardIntent.putExtra("new_card_question", add_card_question_field.text.toString())
                saveCardIntent.putExtra("new_card_answer_1", add_card_answer1_field.text.toString())

//            resultLauncher.launch(saveCardIntent)

                setResult(RESULT_OK, saveCardIntent)

                finish()
            }



        }


    }
}