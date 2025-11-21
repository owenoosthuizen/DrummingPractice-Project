import Controllers.ExerciseController
import Controllers.SessionController
import Utils.*

fun main() {

    val sessionController = SessionController()
    val exerciseController = ExerciseController()


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
                println("Session Added.")
            }

            2 ->{
                val drum = readUserString("Drum: ")
                val desc = readUserString("Description of exercise: ")
                val len = readUserInt("Length in minutes: ")
                val diff = readUserString("How Difficult was it ? (Easy, Medium, Hard): ")

                exerciseController.addExercise(drum,len, diff, desc)
                println("Exercise Added.")
            }

            3 -> {
                println("Your sessions: ")
                println(sessionController.listSessions().forEach { println(it) })
            }

            4 -> {
                println("Your Exercises: ")
                println(exerciseController.listExercise().forEach { println(it) })
            }

            0 -> println("Exiting...")
            else -> println("Invalid choice. Try again.")
        }

    } while (choice != 0)
}
