package com.projects.quizapp

object Constants {

    const val username = "USER_NAME"
    const val totalQuestions = "TOTAL_QUESTIONS"
    const val correctAnswers = "CORRECT_ANSWERS"

    fun getQuestions() : ArrayList<Question>{
        return arrayListOf(
            Question(
                1,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_belgium,
                "Belgium",
                "India",
                "Nepal",
                "USA",
                1
            ),
            Question(
                2,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_argentina,
                "Belgium",
                "Argentina",
                "Nepal",
                "Canada",
                2
            ),
            Question(
                3,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_australia,
                "China",
                "India",
                "Australia",
                "Japan",
                3
            ),
            Question(
                4,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_brazil,
                "Brazil",
                "India",
                "England",
                "USA",
                1
            ),
            Question(
                5,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_germany,
                "Germany",
                "India",
                "Nepal",
                "USA",
                1
            ),
            Question(
                6,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_fiji,
                "Australia",
                "Fiji",
                "Canada",
                "USA",
                2
            ),
            Question(
                7,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_denmark,
                "Belgium",
                "India",
                "Denmark",
                "USA",
                3
            ),
            Question(
                8,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_new_zealand,
                "Japan",
                "New Zealand",
                "Nepal",
                "USA",
                2
            ),
            Question(
                9,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_kuwait,
                "Belgium",
                "Kuwait",
                "Nepal",
                "USA",
                2
            ),
            Question(
                10,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_india,
                "England",
                "India",
                "Nepal",
                "USA",
                2
            )
        )
    }
}