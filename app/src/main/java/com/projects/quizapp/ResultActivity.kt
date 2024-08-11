package com.projects.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projects.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    private var username = ""
    private var totalScore = ""
    private var correctScore = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        username = intent.getStringExtra(Constants.username).toString()
        binding.tvUserName.text = username

        totalScore = intent.getStringExtra(Constants.totalQuestions).toString()
        correctScore = intent.getStringExtra(Constants.correctAnswers).toString()

        binding.tvScore.text = String.format(
            "Your Score is $correctScore out of $totalScore"
        )

        binding.btnFinish.setOnClickListener{
            goToStartActivity()
        }
    }

    private fun goToStartActivity() {
        Intent(this, StartActivity::class.java).apply {
            startActivity(this)
        }
    }
}