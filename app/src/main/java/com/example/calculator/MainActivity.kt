package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var tvCalcWindow : TextView? = null

    private var  lastNum : Boolean = false

    private  var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCalcWindow = findViewById(R.id.tvInput)


        val btn0: Button? = findViewById(R.id._0)
        btn0?.setOnClickListener {
            //tvCalcWindow?.append("0")
            digit(btn0)
        }


        val btn1: Button? = findViewById(R.id._1)
        btn1?.setOnClickListener {
            //tvCalcWindow?.append("1")
            digit(btn1)
        }


        val btn2: Button? = findViewById(R.id._2)
        btn2?.setOnClickListener {
            //tvCalcWindow?.append("2")
            digit(btn2)
        }


        val btn3: Button? = findViewById(R.id._3)
        btn3?.setOnClickListener {
            //tvCalcWindow?.append("3")
            digit(btn3)
        }


        val btn4: Button? = findViewById(R.id._4)
        btn4?.setOnClickListener {
            //tvCalcWindow?.append("4")
            digit(btn4)
        }


        val btn5: Button? = findViewById(R.id._5)
        btn5?.setOnClickListener {
            //tvCalcWindow?.append("5")
            digit(btn5)
        }


        val btn6: Button? = findViewById(R.id._6)
        btn6?.setOnClickListener {
            //tvCalcWindow?.append("6")
            digit(btn6)
        }


        val btn7: Button? = findViewById(R.id._7)
        btn7?.setOnClickListener {
            //tvCalcWindow?.append("7")
            digit(btn7)
        }


        val btn8: Button? = findViewById(R.id._8)
        btn8?.setOnClickListener {
            //tvCalcWindow?.append("8")
            digit(btn8)
        }


        val btn9: Button? = findViewById(R.id._9)
        btn9?.setOnClickListener {
            //tvCalcWindow?.append("9")
            digit(btn9)

        }


        val btnCLR: Button? = findViewById(R.id._CLR)
        btnCLR?.setOnClickListener {
            clr()
        }


        val btnDot: Button? = findViewById(R.id._dot)
        btnDot?.setOnClickListener {
            dot()
        }


        val btnDivide: Button? = findViewById(R.id._divide)
        btnDivide?.setOnClickListener {
            //tvCalcWindow?.append("/")
            operator(btnDivide)
        }

        val btnMultiply: Button? = findViewById(R.id._multiply)
        btnMultiply?.setOnClickListener {
            //tvCalcWindow?.append("*")
            operator(btnMultiply)
        }

        val btnAdd: Button? = findViewById(R.id._add)
        btnAdd?.setOnClickListener {
            //tvCalcWindow?.append("+")
            operator(btnAdd)
        }

        val btnSub: Button? = findViewById(R.id._subtract)
        btnSub?.setOnClickListener {
            //tvCalcWindow?.append("-")
            operator(btnSub)
        }

        val btnEqual: Button? = findViewById(R.id._equals)
        btnEqual?.setOnClickListener {
            equal(btnEqual)
        }


    }

    private fun digit(view: View){
        tvCalcWindow?.append((view as Button).text)
        lastNum = true

    }

    private fun operator(view : View) {

//        tvCalcWindow?.append((view as Button).text)

        tvCalcWindow?.text?.let {

            if (lastNum && !isOperatorPresent(it.toString())) {

                tvCalcWindow?.append((view as Button).text)

                lastNum = false
                lastDot = false

            }
        }
    }

    private fun clr(){
        tvCalcWindow?.text = ""
        lastNum = false
        lastDot = false

    }

    private fun dot(){

        if(lastNum && !lastDot){
            tvCalcWindow?.append(".")

            lastDot = true
            lastNum = false
        }
    }

    private fun equal(view : View){
        if(lastNum){
            var expression = tvCalcWindow?.text.toString()

            var prefix = ""

            try{

                if(expression.startsWith(
                        '-'
                )){
                    expression = expression.substring(1)
                }

                if(expression.contains("-")) {

                    val splitExpression = expression.split("-")
                    var a = splitExpression[0]
                    var b = splitExpression[1]

                    if (prefix.isNotEmpty()) {
                        a = prefix + a
                    }
                    tvCalcWindow?.text = (a.toDouble() - b.toDouble()).toString()

                }

                else if(expression.contains("+")) {

                    val splitExpression = expression.split("+")
                    var a = splitExpression[0]
                    var b = splitExpression[1]

                    if (prefix.isNotEmpty()) {
                        a = prefix + a
                    }
                    tvCalcWindow?.text = (a.toDouble() + b.toDouble()).toString()

                }


                else if(expression.contains("*")) {

                    val splitExpression = expression.split("*")
                    var a = splitExpression[0]
                    var b = splitExpression[1]

                    if (prefix.isNotEmpty()) {
                        a = prefix + a
                    }
                    tvCalcWindow?.text = (a.toDouble() * b.toDouble()).toString()

                }

                else if (expression.contains("/")) {

                    val splitExpression = expression.split("/")
                    var a = splitExpression[0]
                    var b = splitExpression[1]

                    if (prefix.isNotEmpty()) {
                        a = prefix + a
                    }
                    tvCalcWindow?.text = (a.toDouble() / b.toDouble()).toString()

                }

        } catch (e: Exception){
            print(e)
            }
        }
    }

    private fun isOperatorPresent(value: String): Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }

}


