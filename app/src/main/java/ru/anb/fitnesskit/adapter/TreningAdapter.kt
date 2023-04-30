package ru.anb.fitnesskit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.anb.fitnesskit.data.Training
import ru.anb.fitnesskit.databinding.ListitemBinding

class TrainingAdapter(): RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>() {

    class TrainingViewHolder(val binding: ListitemBinding): RecyclerView.ViewHolder(binding.root){

    }
    private var training: List<Training> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
return TrainingViewHolder(
    ListitemBinding.inflate(LayoutInflater.from(parent.context),
    parent,
    false)
)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        val item = training[position]
        with(holder.binding){

        }
    }

    override fun getItemCount() = training.size


}