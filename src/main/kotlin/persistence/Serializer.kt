package persistence

interface Serializer {
    fun read(): Any?
    fun write(obj: Any?)
}