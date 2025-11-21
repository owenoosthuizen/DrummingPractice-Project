package Controllers

import Models.Session
import persistence.DataStore

class SessionController {
    private var lastId = 3
    private fun getId() = ++lastId

    fun addSession(location: String, ownKit: Boolean, cost: Double, day: String) {
        val session = Session(getId(), location, ownKit, cost, day)
        DataStore.sessions.add(session)
    }

    fun listSessions() = DataStore.sessions
}