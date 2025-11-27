import controllers.SessionExerciseController
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import persistence.XMLSerializer
import persistence.JSONSerializer
import java.io.File

class SessionExerciseControllerTest {

    @Test
    fun testLinkExerciseToSession() {
        val controller = SessionExerciseController(XMLSerializer("test-links.xml"))
        controller.linkExerciseToSession(1, 2)

        val list = controller.listAll()
        assertEquals(1, list.size)
        assertEquals(1, list[0].sessionId)
        assertEquals(2, list[0].exerciseId)
    }

    @Test
    fun testMarkCompleted() {
        val controller = SessionExerciseController(XMLSerializer("test-links.xml"))

        controller.linkExerciseToSession(1, 1)
        controller.markCompleted(1, 1, 5)

        val completed = controller.listCompleted()
        assertEquals(1, completed.size)
        assertTrue(completed[0].isCompleted)
        assertEquals(5, completed[0].rating)
    }

    @Test
    fun testSaveAndLoadXML() {
        val file = "test-links.xml"
        val controller1 = SessionExerciseController(XMLSerializer(file))

        controller1.linkExerciseToSession(3, 3)
        controller1.markCompleted(3, 3, 4)
        controller1.save()

        val controller2 = SessionExerciseController(XMLSerializer(file))
        controller2.load()

        assertEquals(1, controller2.listAll().size)
        assertEquals(4, controller2.listAll()[0].rating)

        File(file).delete()
    }

    @Test
    fun testSaveAndLoadJSON() {
        val file = "test-links.json"
        val controller1 = SessionExerciseController(JSONSerializer(file))

        controller1.linkExerciseToSession(2, 5)
        controller1.save()

        val controller2 = SessionExerciseController(JSONSerializer(file))
        controller2.load()

        assertEquals(1, controller2.listAll().size)
        assertEquals(5, controller2.listAll()[0].exerciseId)

        File(file).delete()
    }
}
