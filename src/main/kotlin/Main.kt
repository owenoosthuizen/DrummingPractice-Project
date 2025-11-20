import Controllers.SessionController
import Models.Session
import Utils.*

fun main() {

    val sessionController = SessionController()


    var choice: Int

    do {
        choice = readUserInt("""
            |
            |==================================
            |        WEEKLY DRUM PRACTICE
            |==================================
            | 1. Add Session
            | 2. Add Exercise
            | 3. View Sessions
            | 4. View Sessions
            | 5. Link Exercise to Session
            | 6. Mark Exercise Completed
            | 7. View All Session Exercises
            | 0. Exit
            |----------------------------------
            | > 
        """.trimMargin())

        when (choice) {
            1 -> {
                val loc = readUserString("Location: ")
                val ownKit = readUserBoolean("Own kit (true/false): ")
                val cost = readUserDouble("Cost: ")
                val day = readUserString("Day of week: ")

                sessionController.addSession(loc, ownKit, cost, day)
                println("Session added.")
            }

            else -> println("Invalid choice. Try again.")
        }

    } while (choice != 0)
}
