package Models

data class Session(
    val sessionId: Int,
    val location: String,
    val ownKit: Boolean,
    val cost: Double,
    val dayOfWeek: String,
)