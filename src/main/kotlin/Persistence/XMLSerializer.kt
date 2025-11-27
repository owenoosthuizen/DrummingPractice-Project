package persistence

import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.io.xml.StaxDriver
import java.io.FileReader
import java.io.FileWriter

class XMLSerializer(private val file: String): Serializer {

    private val xstream = XStream(StaxDriver())

    init {
        xstream.allowTypesByWildcard(arrayOf("Models.*", "Controllers.*"))
    }

    override fun write(obj: Any?) {
        val writer = FileWriter(file)
        xstream.toXML(obj, writer)
        writer.close()
    }

    override fun read(): Any? {
        return try {
            val reader = FileReader(file)
            val obj = xstream.fromXML(reader)
            reader.close()
            obj
        } catch (_: Exception) {
            null
        }
    }
}
