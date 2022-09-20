package com.example.hilosejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hilosejemplo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*ir a gradle/Module para activar el binding
    * e inicializar vista de forma mas optima*/

    private lateinit var binding: ActivityMainBinding
    private lateinit var movie:Movie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movie=Movie("La Sirenita",4)
        binding.btnIniciar.setOnClickListener{ iniciarProceso()}
    }

    private fun iniciarProceso() {
        binding.txtDescarga.text="Iniciando Descarga"
        binding.txtDescarga.text="Finalizando Descarga"
    }
}

































