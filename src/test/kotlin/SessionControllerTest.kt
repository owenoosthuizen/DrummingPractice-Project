import controllers.SessionController
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import persistence.XMLSerializer
import persistence.JSONSerializer
import java.io.File

class SessionControllerTest {

    @Test
    fun testAddSession() {
        val controller = SessionController(XMLSerializer("test-sessions.xml"))
        controller.addSession("Studio A", true, 15.0, "Monday")

        val sessions = controller.listSessions()
        assertEquals(1, sessions.size)
        assertEquals("Studio A", sessions[0].location)
    }

    @Test
    fun testSaveAndLoadXML() {
        val file = "test-sessions.xml"
        val controller1 = SessionController(XMLSerializer(file))
        controller1.addSession("Room A", true, 10.0, "Friday")
        controller1.save()

        val controller2 = SessionController(XMLSerializer(file))
        controller2.load()

        assertEquals(1, controller2.listSessions().size)
        assertEquals("Room A", controller2.listSessions()[0].location)

        File(file).delete()
    }

    @Test
    fun testSaveAndLoadJSON() {
        val file = "test-sessions.json"
        val controller1 = SessionController(JSONSerializer(file))
        controller1.addSession("Studio B", false, 0.0, "Tuesday")
        controller1.save()

        val controller2 = SessionController(JSONSerializer(file))
        controller2.load()

        assertEquals(1, controller2.listSessions().size)
        assertEquals("Studio B", controller2.listSessions()[0].location)

        File(file).delete()
    }
}
