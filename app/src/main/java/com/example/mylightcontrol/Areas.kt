package com.example.mylightcontrol

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_areas.*

/*
Proyecto realizado por Guillermo Ramírez
Agosto 2019
Activity que muestra al usuario las áreas diponibles de control de iluminación
 */

class Areas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_areas)
        setSupportActionBar(toolbar)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Iluminación disponible"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Otras funcionalidades", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
