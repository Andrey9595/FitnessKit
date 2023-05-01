package ru.anb.fitnesskit.data

data class LessonEntity(
    val type: TrainingType,
    val lesson: Lesson?,
    val header: String?
)

enum class TrainingType {
    TRAIN, // тренировка в списке
    HEADER // заголовок с датой
}