package jp.techacademy.hideaki.tanigawa.calcapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import jp.techacademy.hideaki.tanigawa.calcapp.databinding.ActivityEditTextBinding
import java.math.BigDecimal

class EditText : AppCompatActivity() {

    private lateinit var binding: ActivityEditTextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTextBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val value1 = intent.getDoubleExtra("VALUE1", 0.0)
        val value2 = intent.getDoubleExtra("VALUE2", 0.0)
        val value3 = intent.getIntExtra("VALUE3",0)
        val bd1 = BigDecimal(value1.toString())
        val bd2 = BigDecimal(value2.toString())

        Log.d("MATH", value1.toString())
        Log.d("MATH", value2.toString())
        Log.d("MATH", value3.toString())

        when(value3){
            1 -> binding.tvResult.text = bd1.add(bd2).toString()
            2 -> binding.tvResult.text = bd1.subtract(bd2).toString()
            3 -> binding.tvResult.text = bd1.multiply(bd2).toString()
            4 -> binding.tvResult.text = bd1.divide(bd2).toString()
        }
    }
}
