package org.tensorflow.lite.examples.classification

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import org.tensorflow.lite.examples.classification.CameraActivity
import kotlinx.android.synthetic.main.fragment_start.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class start : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_start, container, false)
        view.open_camera.setOnClickListener { view ->
//            val intent = Intent (getActivity(), javaClass)

//            getActivity().startActivity(intent)
//            val activity = activity as CameraActivity?
//
//            val intent = Intent (activity, javaClass)
//            startActivity(intent)
//            view.findNavController().navigate(R.id.action_start2_to_cameraActivity)
        }
        return view
    }


}
