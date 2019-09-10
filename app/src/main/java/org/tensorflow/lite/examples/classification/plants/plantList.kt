package org.tensorflow.lite.examples.classification.plants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.tensorflow.lite.examples.classification.R

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_plant_list.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream


class plantList : Fragment() {
    val plants: ArrayList<Plant> = ArrayList()

    private lateinit var adapter: PlantsAdapter
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_plant_list, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fillPlants()
        adapter = PlantsAdapter(plants)
        plantlistView.adapter = adapter
    }

    fun fillPlants() {
        var platsJson = JSONArray(readJSONFromAsset())
        val size: Int = platsJson.length() -1
        for (index in 0..size) {
            val obj = JSONObject(platsJson[index].toString())
            val plant = Plant(obj.optString("name"), obj.optString("group"),
                    obj.optString("description"), obj.optString("img"))
            plants.add(plant)
        }
    }

    fun readJSONFromAsset(): String? {
        var json: String? = null
        try {
            val inputStream: InputStream = context!!.assets.open("plants.json")
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}
