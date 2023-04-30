package ru.anb.fitnesskit.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.anb.fitnesskit.data.Lesson
import ru.anb.fitnesskit.databinding.ListitemBinding

class TrainingAdapter(private val getTrainerById: (String) -> String) :
    RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>() {

    class TrainingViewHolder(val binding: ListitemBinding) : RecyclerView.ViewHolder(binding.root)

    private var training: List<Lesson> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        return TrainingViewHolder(
            ListitemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        val item = training[position]
        with(holder.binding) {
            startTime.text = item.startTime
            lastTime.text = item.endTime
            trening.text = item.name
            color.setBackgroundColor(Color.parseColor(item.color))
            name.text = getTrainerById(item.coachId)
        }
    }

    override fun getItemCount() = training.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Lesson>) {
        training = data
        notifyDataSetChanged()
    }
}