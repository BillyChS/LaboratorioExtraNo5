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

        bTVolver.setOnClickListener(){
            // make a toast on button click event
            //Toast.makeText(this, "Volver al menu", Toast.LENGTH_LONG).show()

            val i = Intent(this@Editar_Persona, CrudPersonas::class.java)
            startActivity(i)

        }

        val editar = findViewById<ImageButton>(R.id.editarButton)

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
        Toast.makeText(this, "Editar", Toast.LENGTH_LONG).show()

        var  nombre = findViewById<EditText>(R.id.agregarUsuario)
        var usuario = findViewById<EditText>(R.id.agregarNombre)
        var password = findViewById<EditText>(R.id.agregarPassword)




        val et_nombre = nombre.text;
        val et_usuario = usuario.text;
        val et_password = password.text;

    }


    private fun CambiarFoto(){

    }
}