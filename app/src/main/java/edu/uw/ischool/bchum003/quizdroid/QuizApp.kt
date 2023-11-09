package edu.uw.ischool.bchum003.quizdroid

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent
class QuizApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("QuizApp", "Application is running")
    }

    companion object {
        private lateinit var instance: QuizApp
        fun getInstance(): QuizApp {
            return instance
        }
    }
}