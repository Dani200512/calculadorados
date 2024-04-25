package com.adso.jjj

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adso.jjj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operation: Char = ' '
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button0.setOnClickListener(this);
        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);
        binding.button4.setOnClickListener(this);
        binding.button5.setOnClickListener(this);
        binding.button6.setOnClickListener(this);
        binding.button7.setOnClickListener(this);
        binding.button8.setOnClickListener(this);
        binding.button9.setOnClickListener(this);

        // Asignar clic listeners a los botones de operaciones
        binding.buttonAdd.setOnClickListener(this);
        binding.buttonSubtract.setOnClickListener(this);
        binding.buttonMultiply.setOnClickListener(this);
        binding.buttonDivide.setOnClickListener(this);
        binding.buttonEquals.setOnClickListener(this);
        binding.buttonClear.setOnClickListener(this);

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button0 -> mostrar("0")
            R.id.button1 -> mostrar("1")
            R.id.button2 -> mostrar("2")
            R.id.button3 -> mostrar("3")
            R.id.button4 -> mostrar("4")
            R.id.button5 -> mostrar("5")
            R.id.button6 -> mostrar("6")
            R.id.button7 -> mostrar("7")
            R.id.button8 -> mostrar("8")
            R.id.button9 -> mostrar("9")
            R.id.buttonAdd -> setOperation('+')
            R.id.buttonSubtract -> setOperation('-')
            R.id.buttonMultiply -> setOperation('*')
            R.id.buttonDivide -> setOperation('/')
            R.id.buttonEquals -> calculate()
            R.id.buttonClear -> clear()
        }
    }

    private fun mostrar(message: String) {
        binding.textView.append(message)
    }

    private fun setOperation(op: Char) {
        if (!binding.textView.text.isNullOrEmpty()){
            operand1 = binding.textView.text.toString().toDouble()
            operation = op
            binding.textView.text= ""
    }
    }


    private fun calculate() {
        if (binding.textView.text.isNotEmpty()) {
            operand2 = binding.textView.text.toString().toDouble()
            //var result = 0.0
            val result   = when (operation) {
                '+' -> operand1 + operand2
                '-' -> operand1 - operand2
                '*' -> operand1 * operand2
                '/' -> {
                    if (operand2 != 0.0){
                        operand1 / operand2
                    }
                    else Double.NaN
                }
                else -> 0.0
            }
            binding.textView.text= ""
            mostrar(result.toString())
        }
    }


    private fun clear() {
        binding.textView.text = ""
        operand1 = 0.0
        operation = ' '
    }
}