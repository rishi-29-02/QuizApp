package com.projects.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.projects.quizapp.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding:ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnEventListeners()
    }

    private fun setOnEventListeners() {
        binding.btnStart.setOnClickListener {
            if(binding.etName.text?.isEmpty() == true){
                Toast.makeText(
                    this,
                    resources.getString(R.string.please_enter_your_name),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Intent(this, QuizQuestionsActivity::class.java).apply {
                    putExtra(Constants.username, binding.etName.text.toString())
                    startActivity(this)
                    finish()
                }
            }
        }
    }
}