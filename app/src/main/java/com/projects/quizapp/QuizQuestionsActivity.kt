package com.projects.quizapp

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.projects.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizQuestionsBinding

    private var questions = ArrayList<Question>()

    private var currentPosition = 0
    private var correctAnswers = 0
    private var selectedOption = -1
    private var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        username = intent.getStringExtra(Constants.username).toString()

        Log.d(Constants.username, username)

        questions = Constants.getQuestions()

        Log.d("questions", questions.size.toString())

        setQuestion(currentPosition, questions[currentPosition])

        setOnEventListener()
    }

    private fun setOnEventListener() {
        binding.OptionOne.setOnClickListener {
            if(binding.btnSubmit.text == resources.getString(R.string.submit) ||
                binding.btnSubmit.text == resources.getString(R.string.finish) ) {
                setOnSelected(it as TextView, 1)
            }
        }

        binding.OptionTwo.setOnClickListener {
            if(binding.btnSubmit.text == resources.getString(R.string.submit) ||
                binding.btnSubmit.text == resources.getString(R.string.finish)) {
                setOnSelected(it as TextView, 2)
            }
        }

        binding.OptionThree.setOnClickListener {
            if(binding.btnSubmit.text == resources.getString(R.string.submit) ||
                binding.btnSubmit.text == resources.getString(R.string.finish)) {
                setOnSelected(it as TextView, 3)
            }
        }

        binding.OptionFour.setOnClickListener {
            if(binding.btnSubmit.text == resources.getString(R.string.submit) ||
                binding.btnSubmit.text == resources.getString(R.string.finish)) {
                setOnSelected(it as TextView, 4)
            }
        }

        binding.btnSubmit.setOnClickListener {
            if (binding.btnSubmit.text == resources.getString(R.string.submit) || binding.btnSubmit.text == resources.getString(R.string.finish)) {
                showResult(questions[currentPosition])
                if (binding.btnSubmit.text == resources.getString(R.string.submit)) {
                    binding.btnSubmit.text = resources.getString(R.string.go_to_next_question)
                } else {
                    binding.btnSubmit.text = resources.getString(R.string.show_results)
                }

            } else if ((binding.btnSubmit.text == resources.getString(R.string.go_to_next_question))) {
                currentPosition++
                setQuestion(currentPosition, questions[currentPosition])
                if (currentPosition < questions.size-1) {
                    binding.btnSubmit.text = resources.getString(R.string.submit)
                } else if (currentPosition == questions.size-1){
                    binding.btnSubmit.text = resources.getString(R.string.finish)
                }
            } else {
                goToResultsActivity()
            }
        }
    }

    private fun showResult(question: Question) {
        if(question.CorrectOption == selectedOption) {
            correctAnswers++
        }

        when (selectedOption) {
            1 -> {
                binding.OptionOne.apply {
                    incorrectSelected(this)
                }
            }
            2 -> {
                binding.OptionTwo.apply {
                    incorrectSelected(this)
                }
            }
            3 -> {
                binding.OptionThree.apply {
                    incorrectSelected(this)
                }
            }
            4 -> {
                binding.OptionFour.apply {
                    incorrectSelected(this)
                }
            }
        }

        when (question.CorrectOption) {
            1 -> {
                binding.OptionOne.apply {
                    correctSelected(this)
                }
            }
            2 -> {
                binding.OptionTwo.apply {
                    correctSelected(this)
                }
            }
            3 -> {
                binding.OptionThree.apply {
                    correctSelected(this)
                }
            }
            4 -> {
                binding.OptionFour.apply {
                    correctSelected(this)
                }
            }
        }
    }

    private fun setQuestion(currentPosition: Int, question: Question) {
        setDefault()
        binding.tvQuestion.text = question.question
        binding.progressBar.progress = currentPosition+1
        binding.tvCount.text = String.format("${currentPosition+1}/${questions.size}")
        binding.ivFlag.setImageResource(question.image)
        binding.OptionOne.text = question.OptionOne
        binding.OptionTwo.text = question.OptionTwo
        binding.OptionThree.text = question.OptionThree
        binding.OptionFour.text = question.OptionFour
    }

    private fun setOnSelected(tv:TextView, selected:Int) {
        setDefault()

        selectedOption = selected

        tv.setTextColor(ContextCompat.getColor(this, R.color.textColor))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_background
        )
    }

    private fun correctSelected(tv:TextView) {
        tv.setTextColor(ContextCompat.getColor(this, R.color.textColor))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.correct_background
        )
    }

    private fun incorrectSelected(tv:TextView) {
        tv.setTextColor(ContextCompat.getColor(this, R.color.textColor))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.incorrect_background
        )
    }

    private fun setDefault() {
        val options = arrayListOf(
            binding.OptionOne,
            binding.OptionTwo,
            binding.OptionThree,
            binding.OptionFour
        )

        options.forEach {
            it.setTextColor(ContextCompat.getColor(this, R.color.textColor))
            it.typeface = Typeface.DEFAULT
            it.background = ContextCompat.getDrawable(
                this,
                R.drawable.option_background
            )
        }
    }

    private fun goToResultsActivity() {
        Intent(this, ResultActivity::class.java).apply {
            putExtra(Constants.username, username)
            putExtra(Constants.totalQuestions, questions.size.toString())
            putExtra(Constants.correctAnswers, correctAnswers.toString())
            startActivity(this)
        }
    }
}