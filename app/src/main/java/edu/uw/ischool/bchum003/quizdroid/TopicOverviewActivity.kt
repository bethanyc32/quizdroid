package edu.uw.ischool.bchum003.quizdroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.TextView;
import android.widget.Button;

class TopicOverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.topic_overview)

        val selectedTopic = intent.getStringExtra("selectedTopic")
        val totalQuestions = 10

        val topicDescriptionTextView = findViewById<TextView>(R.id.topicDescriptionTextView)
        val totalQuestionsTextView = findViewById<TextView>(R.id.totalQuestionsTextView)
        val beginButton = findViewById<Button>(R.id.beginButton)

        topicDescriptionTextView.text = "Description for $selectedTopic"
        totalQuestionsTextView.text = "Total Questions: $totalQuestions"

        beginButton.setOnClickListener {
            val intent = Intent(this, QuestionsActivity::class.java)
            intent.putExtra("selectedTopic", selectedTopic)
            startActivity(intent)
        }
    }
}








