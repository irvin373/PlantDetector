package org.tensorflow.lite.examples.classification.plants


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.json.JSONObject
import org.tensorflow.lite.examples.classification.R
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

import android.widget.ArrayAdapter
import android.widget.ListView

class Attraction(private  val label: String) {
}

class plantList : Fragment() {
//    var array = arrayOf("Melbourne", "Vienna", "Vancouver", "Toronto", "Calgary", "Adelaide", "Perth", "Auckland", "Helsinki", "Hamburg", "Munich", "New York", "Sydney", "Paris", "Cape Town", "Barcelona", "London", "Bangkok")
    var array = arrayListOf<Attraction>(Attraction("send"), Attraction("send2"))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {



        val view: View = inflater.inflate(R.layout.fragment_plant_list, container, false)
        val lv = view.findViewById<ListView>(R.id.recipe_list_view)
        val prodAdapter = ArrayAdapter<Attraction>(context, R.layout.plant_list_item, array)
        lv.adapter = prodAdapter
        return view
//        return inflater.inflate(R.layout.fragment_plant_list, container, false)
    }

    fun fillData () {
        try {
            val jsonfile: String = context!!.assets.open("plants.json").bufferedReader().use {it.readText()}
            val jsonObject = JSONObject(jsonfile)


            val inputStream:InputStream = context!!.assets.open("[\n  {\n    \"name\": \"Eucalipto\",\n    \"plant\": \"send it\"\n  },\n  {\n    \"name\": \"SAbila\",\n    \"plant\": \"send it\"\n  },\n  {\n    \"name\": \"Diente de leon\",\n    \"plant\": \"send it\"\n  }\n]")
            val inputStreamReader = InputStreamReader(inputStream)
            val sb = StringBuilder()
            var line: String?
            val br = BufferedReader(inputStreamReader)
            line = br.readLine()
            while (br.readLine() != null) {
                sb.append(line)
                line = br.readLine()
            }
            br.close()
            Log.d("TAG", sb.toString())
        } catch (e:Exception){
            Log.d("TAG", e.toString())
        }

    }
}
