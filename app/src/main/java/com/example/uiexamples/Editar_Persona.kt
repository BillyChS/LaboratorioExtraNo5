package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class Editar_Persona : AppCompatActivity() {
    private val personas:Personas = Personas.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_persona)


        val bTVolver = findViewById(R.id.volver_crud) as Button
        val editar = findViewById(R.id.editarButton)as ImageButton
        bTVolver.setOnClickListener(){
            // make a toast on button click event
            //Toast.makeText(this, "Volver al menu", Toast.LENGTH_LONG).show()

            val i = Intent(this@Editar_Persona, CrudPersonas::class.java)
            startActivity(i)

        }



        editar.setOnClickListener(){

            editar()
        }


        val bTCambiar = findViewById<Button>(R.id.cambiarFotoButton)

        bTCambiar.setOnClickListener(){
            Toast.makeText(this, "Cambiar Foto", Toast.LENGTH_LONG).show()
            CambiarFoto()
        }

    }

    private fun editar(){
        //Toast.makeText(this, "Editar", Toast.LENGTH_LONG).show()

        var  nombre = findViewById<EditText>(R.id.editarNombre)
        var usuario = findViewById<EditText>(R.id.editarUsuario)
        var password = findViewById<EditText>(R.id.editarPassword)
        val bundle = intent.extras
        val pos = bundle!!.getInt("position")

      //  position = viewHolder.adapterPosition
        var et_nombre = nombre.text
        var et_usuario = usuario.text
        var et_password = password.text
         //Toast.makeText(this, "Prueba de boton", Toast.LENGTH_SHORT).show()

        if(et_nombre.isEmpty() || et_usuario.isEmpty() || et_password.isEmpty()){
            Toast.makeText(this@Editar_Persona, "Hay algun campo vacio", Toast.LENGTH_LONG).show()
        }else{
            var cambio=Persona(et_usuario.toString(),et_password.toString(),et_nombre.toString(),personas.getPersonas()[pos].foto)
            personas.editPerson(cambio,pos)
            this@Editar_Persona.finish()
            val i = Intent(this@Editar_Persona, CrudPersonas::class.java)
            startActivity(i)
            }
       // val i = Intent(this@Editar_Persona, CrudPersonas::class.java)
       // startActivity(i)

    }


    private fun CambiarFoto(){

    }
}