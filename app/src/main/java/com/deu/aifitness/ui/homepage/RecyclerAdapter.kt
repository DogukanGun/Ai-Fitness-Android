package com.deu.aifitness.ui.homepage

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.deu.aifitness.R
import org.w3c.dom.Text

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var text = arrayOf("Squat","Bench Press","Biceps curl","Deadlift","Shoulder Press")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.exercise_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.exercise_item_text.text = text[position]
    }

    override fun getItemCount(): Int {
        return text.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
      //  var itemImage:ImageView
       var exercise_item_text:TextView
       var exercise_item_image:ImageView
//        var itemDetail:TextView

        init{
            exercise_item_text = itemView.findViewById(R.id.exercise_item_text)
            exercise_item_image = itemView.findViewById(R.id.exercise_item_image)
            exercise_item_image.setClipToOutline(true)

            itemView.setOnClickListener {
                val position: Int = adapterPosition
                Log.d("hey", text[position].toString())
//                Toast.makeText(itemView.context, "you clicked on ${text[position]}", Toast.LENGTH_LONG).show()
            }
        }
    }
}