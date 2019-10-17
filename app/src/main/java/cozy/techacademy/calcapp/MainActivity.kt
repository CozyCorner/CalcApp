package cozy.techacademy.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

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
        intent.putExtra("VALUE1", editTextNumber1.text)
        intent.putExtra("VALUE2", editTextNumber2.text)
//        不明点③：どの記号ボタンをタップしたかの結果を、CalacResultShowActivityに渡す方法
        intent.putExtra("OPECODE", 0)

        startActivity(intent)
    }
}