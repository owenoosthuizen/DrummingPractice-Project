import controllers.ExerciseController
import controllers.SessionController
import controllers.SessionExerciseController
import utils.*

fun main() {

    val sessionController = SessionController()
    val exerciseController = ExerciseController()
    val sessionExerciseController = SessionExerciseController()


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
            | 4. View Exercises
            | 5. Link Exercise to Session
            | 6. View All Session Exercises
            | 7. Mark Exercise Completed
            | 8. View all completed exercises
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
                println("Session Added.")
            }

            2 ->{
                val drum = readUserString("Drum Part: ")
                val desc = readUserString("Description of exercise: ")
                val len = readUserInt("Length in minutes: ")
                val diff = readUserString("How Difficult was it ? (Easy, Medium, Hard): ")

                exerciseController.addExercise(drum,len, diff, desc)
                println("Exercise Added.")
            }

            3 -> {
                println("Your sessions: ")
                sessionController.listSessions().forEach { println(it) }
            }

            4 -> {
                println("Your Exercises: ")
                exerciseController.listExercise().forEach { println(it) }
            }

            5 -> {
                val sid = readUserInt("Session ID: ")
                val eid = readUserInt("Exercise ID: ")

                sessionExerciseController.linkExerciseToSession(sid, eid)
                println("Linked.")
            }

            6 -> {
                println("Session Exercises:")
                sessionExerciseController.listAll().forEach { println(it) }
            }

            7-> {
                val sid = readUserInt("Session ID")
                val eid = readUserInt("Exercise ID: ")
                val rating = readUserInt("Rating (1-5): ")

                sessionExerciseController.markCompleted(sid, eid, rating)
                println("Mark completed")
            }

            8-> {
                val completed = sessionExerciseController.listCompleted()

                if (completed.isEmpty()) {
                    println("No completed exercises found.")
                } else {
                    println("Completed Exercises:")
                    completed.forEach { println(it) }
                }
            }

            0 -> println("Exiting...")
            else -> println("Invalid choice. Try again.")
        }

    } while (choice != 0)
}
