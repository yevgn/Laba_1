package ru.aleksandra.laba_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()
    }

    private fun init(){
        val btnGetResult = findViewById<Button>(R.id.btnGetResult)
        // val btnGetResult : Button = findViewById(R.id.btnGetResult)
        // val btnGetResult = findViewById(R.id.btnGetResult) as Button

        val tvInputData = findViewById<TextView>(R.id.tvInputData)
        val edWordLen = findViewById<EditText>(R.id.etWordLen)
        val tvOutputData = findViewById<TextView>(R.id.tvOutputData)

        // Получение массива строк из res -> values -> string-arrays.xml и установка tvInputData
        tvInputData.text = resources
            .getStringArray(R.array.random_words)
            .joinToString(" ")

        btnGetResult.setOnClickListener {

            if(tvInputData.text.isNotEmpty()){

                val lenStr = edWordLen.text.toString()
                val lenInt = if(lenStr.isEmpty() || lenStr.toInt() < 0 ) 0 else lenStr.toInt()

                val textEditor = MyTextEditor()
                val editedText =
                    textEditor.deleteWords(tvInputData.text.split(" "), lenInt)

                val outputToPrint = editedText.joinToString(" ")

                tvOutputData.text = outputToPrint
            }

        }
    }
}

