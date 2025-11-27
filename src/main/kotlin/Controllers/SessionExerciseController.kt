package Controllers

import Models.SessionExercise

class SessionExerciseController {

    private val sessionExercises = mutableListOf<SessionExercise>()

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

    fun listAll() = sessionExercises
}
