package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AgregarPersona : AppCompatActivity() {

    private val personas:Personas = Personas.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_persona)



        val bTVolver = findViewById(R.id.volver) as Button

        bTVolver.setOnClickListener(){
            // make a toast on button click event
            //Toast.makeText(this, "Volver al menu", Toast.LENGTH_LONG).show()

            val i = Intent(this@AgregarPersona, CrudPersonas::class.java)
            startActivity(i)
        }

        val bTAgregar = findViewById<Button>(R.id.agregarButton)

        bTAgregar.setOnClickListener(){
            Agregar()
        }
        val bTCambiar = findViewById<Button>(R.id.cambiarFoto)
        bTCambiar.setOnClickListener(){
            CambiarFoto()
        }

    }

    private fun CambiarFoto(){
        Toast.makeText(this, "Cambiar Foto", Toast.LENGTH_LONG).show()
    }


    private fun Agregar(){

        var  nombre = findViewById<EditText>(R.id.agregarUsuario)
        var usuario = findViewById<EditText>(R.id.agregarNombre)
        var password = findViewById<EditText>(R.id.agregarPassword)




        val et_nombre = nombre.text;
        val et_usuario = usuario.text;
        val et_password = password.text;

        if(et_nombre.isEmpty() || et_usuario.isEmpty() || et_password.isEmpty()){
            Toast.makeText(this@AgregarPersona, "Hay algun campo vacio", Toast.LENGTH_LONG).show()
        }else{
            personas.addPersona(
                Persona(
                    et_usuario.toString(),et_password.toString(),et_nombre.toString(),R.drawable.foto01
                )
            )
            this@AgregarPersona.finish()
            val i = Intent(this@AgregarPersona, CrudPersonas::class.java)
            startActivity(i)
        }



    }
}