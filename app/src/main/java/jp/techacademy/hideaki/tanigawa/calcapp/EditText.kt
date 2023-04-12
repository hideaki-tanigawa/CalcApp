package jp.techacademy.hideaki.tanigawa.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import jp.techacademy.hideaki.tanigawa.calcapp.databinding.ActivityEditTextBinding

class EditText : AppCompatActivity() {

    private lateinit var binding: ActivityEditTextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTextBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val value1 = intent.getIntExtra("VALUE1", 0)
        val value2 = intent.getIntExtra("VALUE2", 0)
        val value3 = intent.getIntExtra("VALUE3",0)

        Log.d("MATH", value1.toString())
        Log.d("MATH", value2.toString())
        Log.d("MATH", value3.toString())

        when(value3){
            1 -> binding.tvResult.text = "${value1 + value2}"
            2 -> binding.tvResult.text = "${value1 - value2}"
            3 -> binding.tvResult.text = "${value1 * value2}"
            4 -> binding.tvResult.text = "${value1 / value2}"
        }
    }
}