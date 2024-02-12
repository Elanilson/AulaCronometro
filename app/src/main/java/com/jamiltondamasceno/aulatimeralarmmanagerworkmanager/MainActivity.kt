package com.jamiltondamasceno.aulatimeralarmmanagerworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import com.jamiltondamasceno.aulatimeralarmmanagerworkmanager.databinding.ActivityMainBinding
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate( layoutInflater )
    }
    private lateinit var timer: Timer
    private lateinit var countDownTimer: CountDownTimer
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        binding.btnIniciar.setOnClickListener {
            countDownTimer = object : CountDownTimer(5000, 1000){
                override fun onTick(millisUntilFinished: Long) {
                    runOnUiThread {
                        binding.textContador.text = millisUntilFinished.toString()
                    }
                }

                override fun onFinish() {
                    binding.textContador.text = "Finalizado"
                }

            }
            countDownTimer.start()

        }



        /*
        timer = Timer()
        binding.btnIniciar.setOnClickListener {
            timer.schedule(
                object : TimerTask(){
                    override fun run() {
                        runOnUiThread {
                            binding.textContador.text = "Executou $contador"
                        }
                        contador++
                    }
                },1000, 2000//10 segundos -> 30 segundos
            )
        }*/

        binding.btnCancelar.setOnClickListener {
            //binding.textContador.text = "Finalizou"
            //timer.cancel()
        }

    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }

}