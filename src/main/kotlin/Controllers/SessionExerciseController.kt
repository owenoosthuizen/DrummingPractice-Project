package Controllers

import Models.SessionExercise

class SessionExerciseController {

    private val sessionExercises = mutableListOf<SessionExercise>()

    fun linkExerciseToSession(sessionId: Int, exerciseId: Int) {
        val link = SessionExercise(sessionId, exerciseId, false, 0)
        sessionExercises.add(link)
    }

    fun listAll() = sessionExercises
}
