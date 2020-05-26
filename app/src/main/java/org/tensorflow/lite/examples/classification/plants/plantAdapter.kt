package org.tensorflow.lite.examples.classification.plants

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import org.tensorflow.lite.examples.classification.R

class AttractionsAdapter(items: ArrayList<Plant>, ctx: Context) :
        ArrayAdapter<Plant>(ctx, R.layout.plant_list_item, items) {

    //view holder is used to prevent findViewById calls
    private class AttractionItemViewHolder {
        internal var image: ImageView? = null
        internal var title: TextView? = null
        internal var description: TextView? = null
        internal var group: TextView? = null
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view

        val viewHolder: AttractionItemViewHolder

        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.plant_list_item, viewGroup, false)

            viewHolder = AttractionItemViewHolder()
            viewHolder.title = view!!.findViewById<View>(R.id.title) as TextView
//            viewHolder.description = view.findViewById<View>(R.id.description) as TextView
            viewHolder.group = view.findViewById<View>(R.id.group) as TextView
            //shows how to apply styles to views of item for specific items
//            if (i == 3)
//                viewHolder.hours!!.setTextColor(Color.DKGRAY)
//            viewHolder.image = view.findViewById<View>(R.id.image) as ImageView
        } else {
            //no need to call findViewById, can use existing ones from saved view holder
//            viewHolder = view.tag as AttractionItemViewHolder
        }

        return view
    }
}