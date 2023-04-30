package ru.anb.fitnesskit.data


import com.google.gson.annotations.SerializedName

data class Training(
    @SerializedName("lessons")
    val lessons: List<Lesson>,
    @SerializedName("option")
    val option: Option,
    @SerializedName("tabs")
    val tabs: List<Tab>,
    @SerializedName("trainers")
    val trainers: List<Trainer>
)