package com.example.mylightcontrol

/*
Proyecto realizado por Guillermo Ramírez
Agosto 2019
Activity de notificaciones
 */

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_notificaciones.*

class Notificaciones : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificaciones)
        setSupportActionBar(toolbar)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Notificaciones"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Funcionalidades Adicionales", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
