package com.deu.aifitness.ui.workoutpage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deu.aifitness.data.workout.Workout
import com.deu.aifitness.databinding.ItemWorkoutBinding


class WorkoutAdapter(
    var itemList: List<Workout>) : RecyclerView.Adapter<WorkoutAdapter.MyPageViewHolder>()
    {
        var listener:WorkoutListener? = null
        class MyPageViewHolder(val binding: ItemWorkoutBinding) : RecyclerView.ViewHolder(
            binding.root) //inner class

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageViewHolder {
            val binding = ItemWorkoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )

            return MyPageViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return itemList.count()
        }

        override fun onBindViewHolder(holder: MyPageViewHolder, position: Int) {
            holder.binding.apply {
                exerciseTV.text = itemList[position].workoutName
                exerciseBTN.setOnClickListener {
                    listener?.workoutClicked(itemList[position])
                }
            }
        }
    }