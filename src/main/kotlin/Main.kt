import Utils.*

fun main() {

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

            else -> println("Invalid choice. Try again.")
        }

    } while (choice != 0)
}
