package com.tdam.intents

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.tdam.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //binding
        setContentView(binding.root) //binding

        setupIntents() //seteamos los intents
    }


    //creamos un metodo para setear los Intents que vayamos a usar
    fun setupIntents(){
        //Aqui seteamos los intents que vayamos a usar
        binding.btWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)

            //Aqui usamos la clase SearchManager para buscar en la web
            intent.putExtra(SearchManager.QUERY, binding.etWeb.text.toString())

            startActivity(intent)

        }

        binding.tvWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")//Para que sepa que se trata de un correo
            //configuramos argumentos
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("binding.tvWeb.text.toString()"))//Aqui se le pasa el correo de los destinatarios que es el mismo texto del textview en este caso
            intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto")//Aqui se le pasa el asunto
            intent.putExtra(Intent.EXTRA_TEXT, "Texto del correo")//Aqui se le pasa el texto del correo

            startActivity(intent)
        }


        binding.tvWebURL.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com")//Aqui se le pasa la url

            startActivity(intent)
        }


        binding.tvTelefono.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            val movil = (it as TextView).text.toString()

            intent.data = Uri.parse("tel:$movil")//Aqui se le pasa el numero de telefono

            startActivity(intent)
        }

    }
}