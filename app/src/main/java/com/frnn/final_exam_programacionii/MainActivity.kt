package com.frnn.final_exam_programacionii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var variable1 = 0.0     //Declaración de varibales para realizar las operaciones
    private var variable2 = 0.0
    private var Operacion = 0

    lateinit var Tview: TextView    //Declaracioón de variables de botones y Textview
    lateinit var Buttonlimpiar: Button
    lateinit var Buttondividir: Button
    lateinit var Buttonmultiplicacion: Button
    lateinit var Buttonsuma: Button
    lateinit var Buttonresta: Button
    lateinit var Buttonigual: Button
    lateinit var Buttonpunto: Button
    lateinit var Buttonuno: Button
    lateinit var Buttondos: Button
    lateinit var Buttontres: Button
    lateinit var Buttoncuatro: Button
    lateinit var Buttoncinco: Button
    lateinit var Buttonseis: Button
    lateinit var Buttonsiete: Button
    lateinit var Buttonocho: Button
    lateinit var Buttonnueve: Button
    lateinit var Buttoncero: Button
    lateinit var Buttoninfo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initEvents() //Iniciar evento para cambiar de activity

        Tview = findViewById(R.id.Tview)    //Declarando valores por medio de id
        Buttonlimpiar = findViewById(R.id.Buttonlimpiar)
        Buttondividir = findViewById(R.id.Buttondividir)
        Buttonmultiplicacion = findViewById(R.id.Buttonmultiplicacion)
        Buttonsuma = findViewById(R.id.Buttonsuma)
        Buttonresta = findViewById(R.id.Buttonresta)
        Buttonigual = findViewById(R.id.Buttonigual)
        Buttonpunto = findViewById(R.id.Buttonpunto)
        Buttonuno = findViewById(R.id.Buttonuno)
        Buttondos = findViewById(R.id.Buttondos)
        Buttontres = findViewById(R.id.Buttontres)
        Buttoncuatro = findViewById(R.id.Buttoncuatro)
        Buttoncinco = findViewById(R.id.Buttoncinco)
        Buttonseis = findViewById(R.id.Buttonseis)
        Buttonsiete = findViewById(R.id.Buttonsiete)
        Buttonocho = findViewById(R.id.Buttonocho)
        Buttonnueve = findViewById(R.id.Buttonnueve)
        Buttoncero = findViewById(R.id.Buttoncero)
        Buttoninfo = findViewById(R.id.Buttoninfo)

        Tview.text = "0"    //Valor a mostrar en el Textview
        Operacion = Sin_Op  //Se mostrará que no existe operación

        Buttonuno.setOnClickListener{NumeroPresionado("1")}     //Valores que se mostrarán al momento de presionar cada uno de los mismos
        Buttondos.setOnClickListener{NumeroPresionado("2")}
        Buttontres.setOnClickListener{NumeroPresionado("3")}
        Buttoncuatro.setOnClickListener{NumeroPresionado("4")}
        Buttoncinco.setOnClickListener{NumeroPresionado("5")}
        Buttonseis.setOnClickListener{NumeroPresionado("6")}
        Buttonsiete.setOnClickListener{NumeroPresionado("7")}
        Buttonocho.setOnClickListener{NumeroPresionado("8")}
        Buttonnueve.setOnClickListener{NumeroPresionado("9")}
        Buttoncero.setOnClickListener{NumeroPresionado("0")}
        Buttonpunto.setOnClickListener{NumeroPresionado(".")}

        Buttonlimpiar.setOnClickListener{LimpiarPantalla()}     //Evento "LimpiarPantalla" que se llamará al momento de dar click en el botón limpiar

        Buttonsuma.setOnClickListener{OperacionPresionada(OpSuma)}    //Evento OpSuma, OpResta, OpMultiplicacion y OpDivision, que se llamarán al momento de dar click en cada uno de los mismos
        Buttonresta.setOnClickListener{OperacionPresionada(OpResta)}
        Buttonmultiplicacion.setOnClickListener{OperacionPresionada(OpMultiplicacion)}
        Buttondividir.setOnClickListener{OperacionPresionada(OpDivision)}

        Buttonigual.setOnClickListener{Resultado()}     //Evento "resultado" que se llamrá al momento de presionar el botón "igual"

    }

    private fun NumeroPresionado(numermo: String){      //Función que verificará el número presionado
        if(Tview.text == "0" && numermo != ".") {
            Tview.text = "$numermo"
        } else {
            Tview.text = "${Tview.text}$numermo"
        }

        if(Operacion == Sin_Op){
            variable1 = Tview.text.toString().toDouble()
        } else {
            variable2 = Tview.text.toString().toDouble()
        }
    }

    private fun OperacionPresionada(Operacion1: Int){   //Función que verificará la operación que se presionó
        this.Operacion = Operacion1
        variable1 = Tview.text.toString().toDouble()

        Tview.text = "0"
    }

    private fun Resultado(){    //Función que dará el resultado en el Textview
        val resultado = when(Operacion) {
            OpSuma -> variable1 + variable2
            OpResta -> variable1 - variable2
            OpMultiplicacion -> variable1 * variable2
            OpDivision -> variable1 / variable2
            else -> 0
        }

        variable1 = resultado as Double

        Tview.text = if("$resultado".endsWith(".0")) { "$resultado".replace(".0","") } else { "%.2f".format(resultado) }
    }

    private fun LimpiarPantalla(){  //Función que limpiará la pantalla al momento de presionarse el botón "C"
        Tview.text = "0"
        variable1 = 0.0
        variable2 = 0.0
    }

    companion object { //Constantes de valores para los botones de operaciones
        const val OpSuma = 1
        const val OpResta = 2
        const val OpMultiplicacion = 3
        const val OpDivision = 4
        const val Sin_Op = 0
    }

    fun initEvents(){   //Función que realizará el cambio de una activity a otra
        val button = findViewById<Button>(R.id.Buttoninfo)
        button.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}