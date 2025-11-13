package persistence

import Models.*

object DataStore {
    val sessions = mutableListOf(
        Session(1, "Studio A", true, 15.0, "Monday"),
        Session(2, "Garage", false, 0.0, "Tuesday"),
        Session(3, "College Music Hall", false, 25.0, "Friday")
    )

    val exercises = mutableListOf(
        Exercise(1, "Snare", 30, "Easy", "Basic rolls"),
        Exercise(2, "Toms", 45, "Medium", "Coordination and fills"),
        Exercise(3, "Toms", 45, "Medium", "Coordination and fills")
    )

    val sessionExercises = mutableListOf(
        SessionExercise(1, 1, true, 4),
        SessionExercise(2, 2, false, 0),
        SessionExercise(3, 3, false, 5 )
    )
}
