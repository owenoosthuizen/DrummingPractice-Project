package Models

data class Exercise (
    val exerciseId: Int,
    val drumPart: String,
    val lengthInMins: Int,
    val difficultyLevel: String,
    val description: String
)