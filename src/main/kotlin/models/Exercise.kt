package models

data class Exercise (
    var exerciseId: Int,
    var drumPart: String,
    var lengthInMins: Int,
    var difficultyLevel: String,
    var description: String
)