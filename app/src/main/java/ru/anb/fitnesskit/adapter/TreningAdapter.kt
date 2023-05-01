package ru.anb.fitnesskit.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.anb.fitnesskit.R
import ru.anb.fitnesskit.data.LessonEntity
import ru.anb.fitnesskit.data.TrainingType


class TrainingAdapter(private val getTrainerById: (String) -> String) :
    RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>() {

    class TrainingViewHolder(view: View) : RecyclerView.ViewHolder(view)

    private var training: List<LessonEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewToInflate = when (viewType) {
            TrainingType.TRAIN.ordinal -> R.layout.listitem
            else -> R.layout.header_item
        }
        return TrainingViewHolder(layoutInflater.inflate(viewToInflate, parent, false))
    }

    override fun getItemViewType(position: Int): Int {
        return training[position].type.ordinal
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        val item = training[position]
        if (item.type == TrainingType.TRAIN) {
            with(holder.itemView) {
                findViewById<TextView>(R.id.startTime).text = item.lesson?.startTime
                findViewById<TextView>(R.id.lastTime).text = item.lesson?.endTime
                findViewById<TextView>(R.id.trening).text = item.lesson?.name
                findViewById<TextView>(R.id.color).setBackgroundColor(Color.parseColor(item.lesson?.color))
                item.lesson?.coachId?.let {
                    findViewById<TextView>(R.id.name).text = getTrainerById(it)
                }
            }
        } else {
            holder.itemView.findViewById<TextView>(R.id.date).text = item.header
        }
    }

    override fun getItemCount() = training.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<LessonEntity>) {
        training = data
        notifyDataSetChanged()
    }
}