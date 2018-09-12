package edu.ualr.mpkennett.classguessinggame

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import java.util.Random

const val SHARED_PREFS_FILE = "edu.ualr.mpkennett.classguessinggame.SHARED_PREFS"
const val KEY_ANSWER = "edu.ualr.mpkennett.classguessinggame.KEY_ANSWER"
const val KEY_GUESS = "edu.ualr.mpkennett.classguessinggame.KEY_GUESS"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startGame(view: View) {
        val theAnswer: Int = (1..5).random()
        Log.d("MPK_UTILITY", "The Answer: " + theAnswer.toString())
        val sharedPreferences =
                getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putInt(KEY_ANSWER, theAnswer)
        editor.apply()

        val intent = Intent(this, GuessActivity::class.java)
        startActivity(intent)
    }

    fun ClosedRange<Int>.random() =
            Random().nextInt((endInclusive + 1) - start) +  start
}
