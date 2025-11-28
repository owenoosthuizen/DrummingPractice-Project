package controllers

import models.Exercise
import persistence.Serializer

class ExerciseController(private val serializer: Serializer) {

    private var exercises = mutableListOf<Exercise>()
    private var lastId = 0
    private fun getId() = ++lastId

    fun addExercise(drum: String, length: Int, difficulty: String, desc: String) {
        exercises.add(Exercise(getId(), drum, length, difficulty, desc))
    }

    fun deleteExercise(id: Int): Boolean {
        val removed = exercises.removeIf { it.exerciseId == id }
        if (removed) save()
        return removed
    }


    fun listExercise() = exercises

    fun save() = serializer.write(exercises)

    fun load() {
        val loaded = serializer.read()
        if (loaded is MutableList<*>) {
            @Suppress("UNCHECKED_CAST")
            exercises = loaded as MutableList<Exercise>
            lastId = exercises.size
        }
    }
}