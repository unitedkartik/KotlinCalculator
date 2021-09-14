package com.gmail.unitedkartik.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNumber = ""
    var op ="+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        var editTextView = findViewById<EditText>(R.id.editText)
        if (isNewOp) editTextView.setText("")
        isNewOp = false

        var buclick = editTextView.text.toString()
        var buselect = view as Button
        when(buselect.id){
            findViewById<Button>(R.id.bu1).id -> {buclick += "1"}
            findViewById<Button>(R.id.bu2).id -> {buclick += "2"}
            findViewById<Button>(R.id.bu3).id -> {buclick += "3"}
            findViewById<Button>(R.id.bu4).id -> {buclick += "4"}
            findViewById<Button>(R.id.bu5).id -> {buclick += "5"}
            findViewById<Button>(R.id.bu6).id -> {buclick += "6"}
            findViewById<Button>(R.id.bu7).id -> {buclick += "7"}
            findViewById<Button>(R.id.bu8).id -> {buclick += "8"}
            findViewById<Button>(R.id.bu9).id -> {buclick += "9"}
            findViewById<Button>(R.id.bu0).id -> {buclick += "0"}
            findViewById<Button>(R.id.buDot).id -> {buclick += "."}
            findViewById<Button>(R.id.buPlusMinus).id -> {
                Log.i("NumberEvent","Inside when case for plus minus: ${buclick.substring(0,1)}")
                if(buclick.substring(0,1).equals("-")){
                    Log.i("NumberEvent","buclick ${buclick.substring(0,1)}")
                    buclick = buclick.substring(1)
                } else {
                    buclick = "-$buclick"
                }
            }
        }
        editTextView.setText(buclick)
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = findViewById<EditText>(R.id.editText).text.toString()
        var buselect = view as Button
        when(buselect.id){
            findViewById<Button>(R.id.buMultiply).id -> {op = "*"}
            findViewById<Button>(R.id.buDivide).id -> {op = "/"}
            findViewById<Button>(R.id.buMinus).id -> {op = "-"}
            findViewById<Button>(R.id.buPlus).id -> {op = "+"}
        }

    }

    fun equalEvent(view: View) {
        var editTextView = findViewById<EditText>(R.id.editText)
        var newnumber = editTextView.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNumber.toDouble() + newnumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newnumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newnumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newnumber.toDouble()}
        }
        editTextView.setText(result.toString())
    }

    fun acEvent(view: View) {
        findViewById<EditText>(R.id.editText).setText("0")
        isNewOp = true
    }

    fun percentageEvent(view: View) {
        var editTextView = findViewById<EditText>(R.id.editText)
        var no = editTextView.text.toString().toDouble() / 100
        editTextView.setText(no.toString())
        isNewOp = true
    }
}