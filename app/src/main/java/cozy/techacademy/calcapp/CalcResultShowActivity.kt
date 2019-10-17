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
//        不明点④：どの記号ボタンをタップしたかの結果を、受け取る方法
        val opecode = intent.getStringExtra("OPECODE")

        if(!TextUtils.isEmpty(value1.toString()) && !TextUtils.isEmpty(value2.toString())){
            textView.text = "エラー：数字を入力してください。"
            exitProcess(-1)
        }

//        不明点⑤：answer変数に値が代入されていない？
        var answer = 7777777f;
        answer = when(opecode) {
            "＋" -> value1 + value2
            "ー" -> value1 - value2
            "×" -> value1 * value2
            "÷" -> value1 / value2 // ゼロで割ったときの例外処理が必要
            else -> -7777777f
        }

//        不明点⑥：textView.textへ変数を代入する方法
        textView.text = "ANSWER"
//        textView.text = "${value1} ${opecode} ${value2} = ${answer}"
//        textView.setText(answer, TextView.BufferType.NORMAL)
    }
}
