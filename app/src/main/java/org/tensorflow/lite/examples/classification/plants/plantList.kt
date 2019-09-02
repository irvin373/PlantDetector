package org.tensorflow.lite.examples.classification.plants


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.tensorflow.lite.examples.classification.R

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_plant_list.*

class Attraction(private  val label: String) {
}

class plantList : Fragment() {
    val plants: ArrayList<Plant> = ArrayList()

    private lateinit var adapter: PlantsAdapter
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_plant_list, container, false)
//        recyclerview.apply {
//            layoutManager = LinearLayoutManager(activity)
//            adapter = PlantsAdapter(plants)
//        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fillPlants()
        adapter = PlantsAdapter(plants)
        plantlistView.adapter = adapter
    }

    fun fillPlants() {
        plants.add(Plant("Plnata 1", "Cardiaca", "no se ricardo"))
        plants.add(Plant("Planta 2", "Cardiaca", "no lo se ricardo"))
    }
}
