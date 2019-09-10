package org.tensorflow.lite.examples.classification.plants

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.plant_list_item.view.*
import org.tensorflow.lite.examples.classification.R
import java.io.IOException

class PlantsAdapter(val items : ArrayList<Plant>)
    : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.title.text = items[position].name
        holder.itemView.group.text = items[position].group
        holder.itemView.description.text = items[position].description

        val assetsBitmap: Bitmap? = getBitmapFromAssets(items[position].img, holder.itemView.context)
        holder.itemView.plant_item_image.setImageBitmap(assetsBitmap)
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

    private fun getBitmapFromAssets(fileName: String, context: Context): Bitmap? {
        return try {
            BitmapFactory.decodeStream(context.assets.open(fileName))
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}

class ViewHolder (containerView: View) : RecyclerView.ViewHolder(containerView) {
    val title = containerView.title
    val group = containerView.group
    val description = containerView.description
    val img = containerView.plant_item_image
}