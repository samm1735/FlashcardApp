package com.example.app2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
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

            val saveCardIntent = Intent()
            val s = add_card_question_field.text.toString()
            val p = add_card_answer1_field.text.toString()

            saveCardIntent.putExtra("new_card_question", add_card_question_field.text.toString())
            saveCardIntent.putExtra("new_card_answer_1", add_card_answer1_field.text.toString())

//            resultLauncher.launch(saveCardIntent)

            setResult(RESULT_OK, saveCardIntent)

            finish()

        }


    }
}