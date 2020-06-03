package org.tensorflow.lite.examples.classification.plants


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import org.tensorflow.lite.examples.classification.R

class PlantDetail : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val safeArgs: PlantDetailArgs by navArgs()
        val flowStepNumber = safeArgs.plantIdNumber
        Toast.makeText(context, "send a file $flowStepNumber", Toast.LENGTH_SHORT).show()
        return inflater.inflate(R.layout.fragment_plant_detail, container, false)
    }


}
