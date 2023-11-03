package edu.uw.ischool.bchum003.quizdroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes

data class Topic(
    val name: String,
    val description: String,
    val totalQuestions: Int
)

val topics = arrayOf(
    Topic("Math", "Mathematics topics", 20),
    Topic("Physics", "Physics topics", 15),
    Topic("Marvel Super Heroes", "Superhero topics", 10)
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topicListView = findViewById<ListView>(R.id.topicList)

        val topicNames = topics.map { it.name }.toTypedArray()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, topicNames)
        topicListView.adapter = adapter

        topicListView.setOnItemClickListener {_, _, position, _ ->
            val selectedTopic = topics[position]

            val intent = Intent(this, TopicOverviewActivity::class.java)
            intent.putExtra("selectedTopic", selectedTopic.name)
            intent.putExtra("description", selectedTopic.description)
            intent.putExtra("totalQuestions", selectedTopic.totalQuestions)

            startActivity(intent)
        }
    }
}