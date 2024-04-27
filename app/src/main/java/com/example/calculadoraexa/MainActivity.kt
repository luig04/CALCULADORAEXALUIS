package com.example.calculadoraexa


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraexa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var operacion: String? = null
    private var OperandorUno: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Seteo de onClickListener de botones
        binding.apply {
            boton0.setOnClickListener { numeroPulsado("0") }
            boton1.setOnClickListener { numeroPulsado("1") }
            boton2.setOnClickListener { numeroPulsado("2") }
            boton3.setOnClickListener { numeroPulsado("3") }
            boton4.setOnClickListener { numeroPulsado("4") }
            boton5.setOnClickListener { numeroPulsado("5") }
            boton6.setOnClickListener { numeroPulsado("6") }
            boton7.setOnClickListener { numeroPulsado("7") }
            boton8.setOnClickListener { numeroPulsado("8") }
            boton9.setOnClickListener { numeroPulsado("9") }
            botonPunto.setOnClickListener { numeroPulsado(".") }

            botonSumar.setOnClickListener { operacionPulsada('+') }
            botonRestar.setOnClickListener { operacionPulsada('-') }
            botonMultiplicar.setOnClickListener { operacionPulsada('*') }
            botondividir.setOnClickListener { operacionPulsada('/') }

            botonatras.setOnClickListener { borrar() }
            botonC.setOnClickListener { clear() }
            botonSalir.setOnClickListener { finish() }

            botonigual.setOnClickListener { calcularResultado() }
        }

    }


    private fun numeroPulsado(digito: String) {
        binding.textocaja.append(digito)
    }

    private fun operacionPulsada(operador: Char) {
        operacion = operador.toString()
        OperandorUno = binding.textocaja.text.toString().toDoubleOrNull()
        binding.textocaja.text.clear()
    }



    private fun calcularResultado() {
        val operandor2 = binding.textocaja.text.toString().toDoubleOrNull()
        if (OperandorUno != null && operandor2 != null && operacion != null) {
            val resultado = when (operacion) {
                "+" -> OperandorUno!! + operandor2
                "-" -> OperandorUno!! - operandor2
                "*" -> OperandorUno!! * operandor2
                "/" -> if (operandor2 != 0.0) OperandorUno!! / operandor2 else Double.NaN
                else -> Double.NaN
            }
            binding.textocaja.text.clear()
            binding.textocaja.append(resultado.toString())
            operacion = null
            OperandorUno = null
        }
    }

    private fun borrar() {
        val texto = binding.textocaja.text.toString()
        if (texto.isNotEmpty()) {
            binding.textocaja.setText(texto.substring(0, texto.length - 1))
        }
    }
    private fun clear() {
        binding.textocaja.text.clear()
        operacion = null
        OperandorUno = null
    }


}
