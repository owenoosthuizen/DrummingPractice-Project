package Controllers

import Models.Exercise
import persistence.DataStore

class ExerciseController {

    private val exercises = mutableListOf<Exercise>()
    private var lastId = 0
    private fun getId() = ++lastId

    fun addExercise(drum:  String , length:  Int , difficulty:  String , desc:  String ){
        val exercise = Exercise(getId(), drum, length, difficulty, desc)
        exercises.add(exercise)
    }
    fun listExercise() = exercises
}