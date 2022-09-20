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
        binding.btnIniciar.setOnClickListener{
            iniciarHilo()
            iniciarProceso()}
    }

    private fun iniciarProceso() {
        binding.txtDescarga.text="Iniciando Descarga"
        //Thread.sleep(5000)
        binding.txtDescarga.text="Finalizando Descarga"
        binding.txtEjecucion.text=movie.play()
    }
    private fun iniciarHilo(){
        /*Al configurar un hilo debemos implementar una interfaz
        * denominada Runnable (Comando de instrucciones)
        * a ejecutar... en esa interfaz existe una regla del juego que se
        * llama run() todo lo que coloquemos dentro de run es lo que se
        * ejecutara en segundo plano*/
        binding.txtDescarga.text="Iniciando Descarga"
        val hilo=Thread(Runnable {
            try{
                /*Estamos implementando directamente el run()*/
                Thread.sleep(8000)
                //Para hablar con la interfaz de usuario UI desde un hilo
                //tenemos que crear un canal de comunicacion
                runOnUiThread{binding.txtDescarga.text="Descarga Finalizada"
                }

            }catch (e:InterruptedException){
                e.printStackTrace()
            }


        })
        /*Para que el hilo arranque y ejecute todo lo que esta
        * en run () tienen queutilizar el metodo start()*/
        hilo.start()
    }
}

































