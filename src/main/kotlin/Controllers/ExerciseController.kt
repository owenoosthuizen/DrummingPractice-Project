package Controllers

import Models.Exercise
import persistence.DataStore

class ExerciseController {
    private var lastId = 3
    private fun getId() = ++lastId

    fun addExercise(drum: String, length: Int, difficulty: String, desc: String){
        val exercise = Exercise(getId(), drum, length, difficulty, desc)
        DataStore.exercises.add(exercise)
    }
    fun listExercise() = DataStore.exercises
}