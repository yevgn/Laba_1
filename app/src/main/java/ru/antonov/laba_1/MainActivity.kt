package ru.antonov.laba_1

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

        val btnGetResult = findViewById<Button>(R.id.btnGetResult)
        val tvInputData = findViewById<TextView>(R.id.tvInputData)
        val edWordLen = findViewById<EditText>(R.id.etWordLen)
        val tvOutputData = findViewById<TextView>(R.id.tvOutputData)

        var len : Int

        btnGetResult.setOnClickListener {
            if(tvInputData.text.isNotEmpty()){
                var lenStr = edWordLen.text.toString()

                len = if(lenStr.isEmpty() || lenStr.toInt() < 0 ) 0
                        else edWordLen.text.toString().toInt()

                val textEditor = MyTextEditor()
                val editedText =
                    textEditor.deleteWords(tvInputData.text.split(" "), len)

                var outputToPrint = ""
                for(str in editedText)
                    outputToPrint += "$str "

                tvOutputData.text = outputToPrint
            }
        }

    }
}

