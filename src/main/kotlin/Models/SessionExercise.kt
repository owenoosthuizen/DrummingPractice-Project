package Models

data class SessionExercise(
    var sessionId: Int,
    var exerciseId: Int,
    var isCompleted: Boolean,
    var rating: Int,
)