package org.tensorflow.lite.examples.classification.plants

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.plant_list_item.view.*
import org.tensorflow.lite.examples.classification.ClassifierActivity
import org.tensorflow.lite.examples.classification.R

class PlantsAdapter(val items : ArrayList<Plant>)
    : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.title.text = items[position].name
        holder.itemView.group.text = items[position].group
        holder.itemView.description.text = items[position].description
        holder.itemView.card_view.setOnClickListener{view ->
            Toast.makeText(view.context, "send a file", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.plant_list_item, parent, false)
        return ViewHolder(view)
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder (containerView: View) : RecyclerView.ViewHolder(containerView) {
    val title = containerView.title
    val group = containerView.group
    val description = containerView.description
}