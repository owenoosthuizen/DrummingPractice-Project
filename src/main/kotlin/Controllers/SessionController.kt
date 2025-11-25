package Controllers

import Models.Session
import persistence.DataStore

class SessionController {

    private val sessions = mutableListOf<Session>()
    private var lastId = 3
    private fun getId() = ++lastId

    fun addSession(location: String, ownKit: Boolean, cost: Double, day: String) {
        val session = Session(getId(), location, ownKit, cost, day)
        sessions.add(session)
    }

    fun listSessions() = sessions
}