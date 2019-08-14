package com.example.mylightcontrol

/*
Proyecto realizado por Guillermo Ramírez
Agosto 2019
Activity de que muestra la politica de privacidad. La activity "Politica no se USA es un remanente
 */

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_politica2.*

class Politica2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_politica2)
        setSupportActionBar(toolbar)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Politica de privacidad"
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
