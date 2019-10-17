package cozy.techacademy.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, CalcResultShowActivity::class.java)

        try {
            intent.putExtra("VALUE1", editTextNumber1.text.toString().toFloat())
            intent.putExtra("VALUE2", editTextNumber2.text.toString().toFloat())
        } catch (e: Exception) {
            Log.d("DEBUG_LOG", e.message)

            intent.putExtra("VALUE1", 123f)
            intent.putExtra("VALUE2", 456f)
        }
        
        if (v!!.id == R.id.buttonPlus) {
            intent.putExtra("OPECODE", "＋")
        } else if (v!!.id == R.id.buttonMinus) {
            intent.putExtra("OPECODE", "ー")
        } else if (v!!.id == R.id.buttonMultiply) {
            intent.putExtra("OPECODE", "×")
        } else if (v!!.id == R.id.buttonDivide) {
            intent.putExtra("OPECODE", "÷")
        }

        startActivity(intent)
    }
}