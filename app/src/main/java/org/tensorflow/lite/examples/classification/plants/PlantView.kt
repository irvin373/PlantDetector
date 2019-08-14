package org.tensorflow.lite.examples.classification.plants

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_plant_view.*
import org.tensorflow.lite.examples.classification.ClassifierActivity
import org.tensorflow.lite.examples.classification.R

class PlantView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_view)
        setSupportActionBar(toolbar)

        val intent: Intent = getIntent()
        val value = intent.getStringExtra("label")
        if (!value.isNullOrEmpty()) {
            val toast: Toast = Toast.makeText(this, value, Toast.LENGTH_LONG)
            toast.show()
        }

        fab.setOnClickListener { view ->
            val intent = Intent(this, ClassifierActivity::class.java)
            startActivity(intent)
        }
    }

}
