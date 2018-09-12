package edu.ualr.mpkennett.classguessinggame

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class GuessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
    }

    fun getGuess(view: View) {
        val userGuessTextBox: EditText =
                findViewById(R.id.userGuess)

        val sharedPreferences =
                getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putInt(KEY_GUESS, userGuessTextBox.text.toString().toInt())
        editor.apply()

        val intent: Intent =
                Intent(this, EvaluateActivity::class.java)
        startActivity(intent)
    }
}
