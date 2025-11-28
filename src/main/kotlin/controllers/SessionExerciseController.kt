package controllers

import models.SessionExercise
import persistence.Serializer

class SessionExerciseController(private val serializer: Serializer) {

    private var sessionExercises = mutableListOf<SessionExercise>()

    fun linkExerciseToSession(sessionId: Int, exerciseId: Int) {
        val link = SessionExercise(sessionId, exerciseId, false, 0)
        sessionExercises.add(link)
    }
    fun markCompleted(sessionId: Int , exerciseId: Int , rating: Int ) {
        val record = sessionExercises.find {
            it.sessionId == sessionId && it.exerciseId == exerciseId
        }
        if (record != null) {
            val index = sessionExercises.indexOf(record)
            sessionExercises[index] = record.copy(isCompleted = true, rating = rating)
        }
    }

    fun listCompleted(): List<SessionExercise> {
        return sessionExercises.filter { it.isCompleted }
    }

    fun deleteLink(sessionId: Int, exerciseId: Int): Boolean {
        val removed = sessionExercises.removeIf {
            it.sessionId == sessionId && it.exerciseId == exerciseId
        }
        if (removed) save()
        return removed
    }


    fun listAll() = sessionExercises

    fun save() = serializer.write(sessionExercises)

    fun load() {
        val loaded = serializer.read()
        if (loaded is MutableList<*>) {
            @Suppress("UNCHECKED_CAST")
            sessionExercises = loaded as MutableList<SessionExercise>
        }
    }
}
