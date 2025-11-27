package models

data class Session(
    var sessionId: Int,
    var location: String,
    var ownKit: Boolean,
    var cost: Double,
    var dayOfWeek: String,
)