package Models

data class SessionExercise(
    val sessionId: Int,
    val exerciseId: Int,
    var isCompleted: Boolean,
    var rating: Int,
)