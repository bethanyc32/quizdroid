package edu.uw.ischool.bchum003.quizdroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView;
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.RadioButton;
import android.widget.Button;

data class TopicQuestions(
    val name: String,
    val question1: String,
    val q1option1: String,
    val q1option2: String,
    val q1option3: String,
    val q1option4: String,

    val question2: String,
    val q2option1: String,
    val q2option2: String,
    val q2option3: String,
    val q2option4: String,

    val question3: String,
    val q3option1: String,
    val q3option2: String,
    val q3option3: String,
    val q3option4: String,

    val question4: String,
    val q4option1: String,
    val q4option2: String,
    val q4option3: String,
    val q4option4: String,

    val question5: String,
    val q5option1: String,
    val q5option2: String,
    val q5option3: String,
    val q5option4: String
)

val questionsData = arrayOf(
    TopicQuestions(
        "Math",
        "5 + 3 =",
        "5", "6", "8", "10",
        "13-2",
        "4", "7", "11", "14",
        "3 + 8",
        "3", "6", "8", "11",
        "7-4",
        "1", "2", "3", "4",
        "18-5",
        "4", "10", "13", "16"),
    TopicQuestions("Physics",
        "How many seconds in a minute?",
        "60", "70", "80", "100",
        "How many minutes in one hour?",
        "40", "70", "50", "60",
        "How many meters in a kilometer?",
        "100", "1000", "10000", "100000",
        "How many centimeters in a meter?",
        "100", "500", "10", "50",
        "How many grams in a kilogram?",
        "50", "100", "500", "1000"),
    TopicQuestions("Marvel Super Heroes",
        "What year was first Iron Man movie released?",
        "2016", "2000", "2008", "2010",
        "What is Spiderman's first name?",
        "Peter", "Parker", "Panther", "Paul",
        "Who is Thor's brother?",
        "Iron Man", "Spiderman", "Loki", "Captain America",
        "What color is the Hulk?",
        "purple", "blue", "red", "green",
        "What is Dr. Strange's first name?",
        "Stephen", "Peter", "Evan", "Stan")
)

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_questions)

        val selectedTopic = intent.getStringExtra("selectedTopic")
        val question = findViewById<TextView>(R.id.topicQuestion)
        // question.text = questionsData

        // question.text = "hello"

    }
}