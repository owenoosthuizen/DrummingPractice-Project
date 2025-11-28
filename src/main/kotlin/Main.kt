import controllers.ExerciseController
import controllers.SessionController
import controllers.SessionExerciseController
import utils.readUserInt
import utils.readUserString
import utils.readUserDouble
import utils.readUserBoolean
import persistence.XMLSerializer

fun main() {

    val sessionController = SessionController(XMLSerializer("sessions.xml"))
    val exerciseController = ExerciseController(XMLSerializer("exercises.xml"))
    val sessionExerciseController = SessionExerciseController(XMLSerializer("sessionexercises.xml"))

    exerciseController.load()
    sessionController.load()
    sessionExerciseController.load()


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
            | 9. Delete Session
            | 10. Delete Exercise
            | 11. Delete Session Exercise link
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
                sessionController.save()
            }

            2 ->{
                val drum = readUserString("Drum Part: ")
                val desc = readUserString("Description of exercise: ")
                val len = readUserInt("Length in minutes: ")
                val diff = readUserString("How Difficult was it ? (Easy, Medium, Hard): ")

                exerciseController.addExercise(drum,len, diff, desc)
                println("Exercise Added.")
                exerciseController.save()
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
                sessionExerciseController.save()
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
                sessionExerciseController.save()
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

            9-> {
                val id = readUserInt("Session ID to delete: ")
                if (sessionController.deleteSession(id))
                    println("Session deleted.")
                else
                    println("Session not found.")
            }

            10-> {
                val id = readUserInt("Exercise ID to delete")
                if (exerciseController.deleteExercise(id))
                    println("Execise deleted.")
                else
                    println("Exercise not found.")
            }

            11-> {
                val sid = readUserInt("Session ID: ")
                val eid = readUserInt("Exercise ID: ")
                if (sessionExerciseController.deleteLink(sid, eid))
                    println("Link deleted.")
                else
                    println("Link not found.")
            }

            0 -> {
                sessionController.save()
                exerciseController.save()
                sessionExerciseController.save()
            }
        }

    } while (choice != 0)
}
