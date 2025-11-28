A simple Kotlin console application for managing drum practice sessions, exercises, and completed practice records.
The app supports adding, viewing, deleting, linking, completing, and saving/loading data using XML or JSON.

Features:
Add, view, and delete sessions
Add, view, and delete exercises
Link exercises to sessions
Mark a linked exercise as completed (with rating)
View all completed exercises
XML and JSON persistence (using XStream)
Automatically loads data on startup and saves on exit
Basic input validation through utility functions


Project Structure
controllers/     → Session, Exercise, and SessionExercise controllers
models/          → Data classes (Session, Exercise, SessionExercise)
persistence/     → Serializer, XMLSerializer, JSONSerializer
utils/           → Input helper functions
Main.kt          → Console menu and application entry point
tests/           → JUnit tests for all controllers
