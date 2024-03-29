package cozy.techacademy.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_calc_result_show.*
import kotlin.system.exitProcess

class CalcResultShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_result_show)

        val value1 = intent.getFloatExtra("VALUE1", 0f)
        val value2 = intent.getFloatExtra("VALUE2", 0f)
        val opecode = intent.getStringExtra("OPECODE")

        var answer = 7777777f;
        answer = when(opecode) {
            "＋" -> value1 + value2
            "ー" -> value1 - value2
            "×" -> value1 * value2
            "÷" -> value1 / value2 // ゼロで割ったときの例外処理が必要
            else -> -7777777f
        }

        textView.text = "${value1} ${opecode} ${value2} = ${answer}"
    }
}
