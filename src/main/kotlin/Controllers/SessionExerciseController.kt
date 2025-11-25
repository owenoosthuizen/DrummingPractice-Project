package Controllers

import Models.SessionExercise
import persistence.DataStore

class SessionExerciseController {

    fun linkExerciseToSession(sessionId: Int, exerciseId: Int) {
        DataStore.sessionExercises.add(SessionExercise(sessionId, exerciseId, false, 0))
    }

    fun listAll() = DataStore.sessionExercises
}