import controllers.ExerciseController
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import persistence.XMLSerializer
import persistence.JSONSerializer
import java.io.File

class ExerciseControllerTest {

    @Test
    fun testAddExercise() {
        val controller = ExerciseController(XMLSerializer("test-exercises.xml"))
        controller.addExercise("Snare", 30, "Easy", "Basic rolls")

        val exercises = controller.listExercise()
        assertEquals(1, exercises.size)
        assertEquals("Snare", exercises[0].drumPart)
    }

    @Test
    fun testSaveAndLoadXML() {
        val file = "test-exercises.xml"
        val controller1 = ExerciseController(XMLSerializer(file))
        controller1.addExercise("Toms", 45, "Medium", "Coordination")
        controller1.save()

        val controller2 = ExerciseController(XMLSerializer(file))
        controller2.load()

        assertEquals(1, controller2.listExercise().size)
        assertEquals("Toms", controller2.listExercise()[0].drumPart)

        File(file).delete()
    }

    @Test
    fun testSaveAndLoadJSON() {
        val file = "test-exercises.json"
        val controller1 = ExerciseController(JSONSerializer(file))
        controller1.addExercise("Kick", 15, "Hard", "Speed work")
        controller1.save()

        val controller2 = ExerciseController(JSONSerializer(file))
        controller2.load()

        assertEquals(1, controller2.listExercise().size)
        assertEquals("Kick", controller2.listExercise()[0].drumPart)

        File(file).delete()
    }
}
