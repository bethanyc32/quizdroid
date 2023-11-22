package edu.uw.ischool.bchum003.quizdroid

import android.app.Application
import android.util.Log
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

data class Quiz(
    val questionText: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
)

data class Topic(
    val title: String,
    val shortDescription: String,
    val longDescription: String,
    val quizzes: List<Quiz>
)

interface TopicRepository {
    fun getTopics(): List<Topic>
    fun getTopicById(topicId: Int): Topic?
}

abstract class InMemoryTopicRepository : TopicRepository {
    private val topics: List<Topic> = listOf(
        // Initialize your topics here
        Topic("Math", "Short description for Math", "Long description for Math", listOf(
            Quiz("What is 2 + 2?", listOf("3", "4", "5", "6"), 1),
            Quiz("What is 2 + 3?", listOf("3", "4", "5", "6"), 2),
            Quiz("What is 2 + 4?", listOf("3", "4", "5", "6"), 3)
        )),
        Topic("Physics", "Short description for Physics", "Long description for Physics", listOf(
            Quiz("How many seconds in a minute?", listOf("60", "70", "80", "100"), 1),
            Quiz("How many minutes in one hour?", listOf("40", "70", "50", "60"), 2),
            Quiz("How many meters in a kilometer?", listOf("100", "1000", "10000", "100000"), 3)
        ))
        // Add more topics
    )

    fun getAll(): List<Topic> {
        return topics
    }

    //override fun getTopicById(topicId: Int): Topic? {
    //    return topics.find { it.title == topicId }
    //}
}

object QuizApp : Application() {
    private var topicRepository: TopicRepository? = null

    override fun onCreate() {
        super.onCreate()
        Log.d("QuizApp", "Application is running")
    }

    //object {
    //    private lateinit var instance: QuizApp
    //    fun getInstance(): QuizApp {
    //        return instance
    //    }
    //}

    fun getTopicRepository(): TopicRepository {
        if (topicRepository == null) {
            // Initialize the repository here, e.g., a simple in-memory implementation.
            topicRepository = InMemoryTopicRepository()
        }
        return topicRepository!!
    }
}