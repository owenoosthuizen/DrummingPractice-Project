package controllers

import models.Session
import persistence.Serializer

class SessionController(private val serializer: Serializer) {

    private var sessions = mutableListOf<Session>()
    private var lastId = 0
    private fun getId() = ++lastId

    fun addSession(location: String, ownKit: Boolean, cost: Double, day: String) {
        sessions.add(Session(getId(), location, ownKit, cost, day))
    }

    fun deleteSession(id: Int): Boolean {
        val removed = sessions.removeIf { it.sessionId == id }
        if (removed) save()
        return removed
    }

    fun listSessions() = sessions

    fun save() = serializer.write(sessions)

    fun load() {
        val loaded = serializer.read()
        if (loaded is MutableList<*>) {
            @Suppress("UNCHECKED_CAST")
            sessions = loaded as MutableList<Session>
            lastId = sessions.size
        }
    }
}