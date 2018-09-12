package edu.ualr.mpkennett.classguessinggame

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EvaluateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_evaluate)
    }

    override fun onResume() {
        super.onResume()

        val resultTextView: TextView =
                findViewById(R.id.resultTextView)
        val nextButton : Button =
                findViewById(R.id.nextButton)

        val sharedPreferences =
                getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)

        val theAnswer: Int = sharedPreferences.getInt(KEY_ANSWER, -1)
        val userGuess: Int = sharedPreferences.getInt(KEY_GUESS, -1)

        val userIsCorrect: Boolean =
                (theAnswer == userGuess)

        if(userIsCorrect) {
            // Update resultTextView and nextButton to show
            // that they were correct
            resultTextView.text = "Good Guess!  You Win!"
            nextButton.text = "Start Over"
            nextButton.setOnClickListener {
                val intent: Intent =
                        Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        else {
            resultTextView.text = "Nope, try again!"
            nextButton.text = "Try Again"
            nextButton.setOnClickListener {
                val intent: Intent =
                        Intent(this, GuessActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
