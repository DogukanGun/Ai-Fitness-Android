package com.deu.aifitness.ui.workoutpage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deu.aifitness.data.workout.Workout
import com.deu.aifitness.databinding.ItemWorkoutBinding


class WorkoutAdapter(
    var itemList: List<Workout>) : RecyclerView.Adapter<WorkoutAdapter.MyPageViewHolder>()
    {
        class MyPageViewHolder(val binding: ItemWorkoutBinding) : RecyclerView.ViewHolder(
            binding.root) //inner class

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageViewHolder {
            val binding = ItemWorkoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )

            return MyPageViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return 5
        }

        override fun onBindViewHolder(holder: MyPageViewHolder, position: Int) {
            holder.binding.apply {

            }
        }
    }