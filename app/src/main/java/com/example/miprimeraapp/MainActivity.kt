package com.example.miprimeraapp
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.miprimeraapp.R.id.btnLanzar
import com.example.miprimeraapp.R.id.txtResultado
import kotlin.math.min
import kotlin.system.measureTimeMillis


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    val btnLanzar: Button= findViewById(btnLanzar)
    btnLanzar.setOnClickListener{
        rollDice()
    }
    }
    private fun rollDice(){
        var numero: Int = lanzar(max = 6)
        val txtResult: TextView= findViewById(txtResultado)
        txtResult.text=numero.toString()

       val drawableResource = when(numero){
            1->R.drawable.d1
            2->R.drawable.d2
            3->R.drawable.d3
            4->R.drawable.d4
            5->R.drawable.d5
            else ->R.drawable.d6
        }
        val imgDado2: ImageView= findViewById(R.id.imgDado2)
        imgDado2.setImageResource(drawableResource)
        
        //Toast.makeText(this, numero.toString(), Toast.LENGTH_LONG).show()
}
    private fun lanzar(max: Int): Int{
        return (1..max).random()
    }
    private fun tiempo(){
        object : CountDownTimer(3000, 150) {
            override fun onTick(millisUntilFinished: Long) {
                rollDice()
            }
            override fun onFinish() {
            }
        }.start()
    }
}
