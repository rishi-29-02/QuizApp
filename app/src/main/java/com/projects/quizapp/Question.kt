package com.projects.quizapp

data class Question(
    var id:Int,
    var question:String,
    var image:Int,
    var OptionOne:String,
    var OptionTwo:String,
    var OptionThree:String,
    var OptionFour:String,
    var CorrectOption:Int
)
