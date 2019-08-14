package com.example.mylightcontrol

/*
Proyecto realizado por Guillermo Ramírez
Agosto 2019
Activity princiapl que muestra el funcionamiento del SWITCH y el web servive mediante Volley,
LA explicación de este segmento de código se encuentra en el documento de la actividad
 */

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import android.widget.Switch
import android.widget.Toast

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.mylightcontrol.Politica

import org.json.JSONArray //Para el manejo de

/*
Proyecto realizado por Guillermo Ramírez
Agosto 2019
Activity princiapl que muestra el funcionamiento del SWITCH y el web servive mediante Volley,
LA explicación de este segmento de código se encuentra en el documento de la actividad
 */

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private lateinit var mySwitch: Switch
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {//Botones de la Barra de navegación
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val intent = Intent(this,Areas::class.java)
                startActivity(intent)
                //textMessage.setText(R.string.title_dashboard)
                //return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val intent = Intent(this,Notificaciones::class.java)
                startActivity(intent)
                //textMessage.setText(R.string.title_notifications)
                //return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        mySwitch=findViewById(R.id.switch1) //Definición del objeto switch

        mySwitch.setOnClickListener{//Eventos del SWITCH
            if(mySwitch.isChecked){
                mySwitch.text="Prendido"//Estado del switch y del web service

                //Web Service

                 val jsonArray=JSONArray()
                 jsonArray.put(1)
                 jsonArray.put(1)


                 val cola = Volley.newRequestQueue(this)//cola de peticiones de Volley
                 val url = "http://35.238.212.148:8080/wsREST/webresources/entity.autor/1"
                 //Toast.makeText(this, jsonArray.toString(), Toast.LENGTH_LONG).show()


                 val elJson = JsonArrayRequest(Request.Method.POST,url,jsonArray,
                     Response.Listener{ response ->
                         Log.i("e","Request=$response")
                         Toast.makeText(this, "Servicio Web en 1", Toast.LENGTH_LONG).show()
                     },
                     Response.ErrorListener { error ->
                         error.printStackTrace()
                         Toast.makeText(this, "Servicio Web en 1", Toast.LENGTH_LONG).show()
                     })


                 cola.add(elJson)

            }
            else
            {
                mySwitch.text="Apagado"

                //Web Service

                val jsonArray=JSONArray()
                jsonArray.put(1)
                jsonArray.put(0)


                val cola = Volley.newRequestQueue(this)
                val url = "http://35.238.212.148:8080/wsREST/webresources/entity.autor/1"
                //Toast.makeText(this, jsonArray.toString(), Toast.LENGTH_LONG).show()


                val elJson = JsonArrayRequest(Request.Method.POST,url,jsonArray,
                    Response.Listener{ response ->
                        Log.i("e","Request=$response")
                        Toast.makeText(this, "Servicio web en 0", Toast.LENGTH_LONG).show()
                    },
                    Response.ErrorListener { error ->
                        error.printStackTrace()
                        Toast.makeText(this, "Servicio web en 0", Toast.LENGTH_LONG).show()
                    })


                cola.add(elJson)

            }
        }

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "MyLight Control 1.0"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
