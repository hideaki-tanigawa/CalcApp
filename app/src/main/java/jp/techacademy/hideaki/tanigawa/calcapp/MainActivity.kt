package jp.techacademy.hideaki.tanigawa.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import jp.techacademy.hideaki.tanigawa.calcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btSum.setOnClickListener(this)
        binding.btSubtraction.setOnClickListener(this)
        binding.btMultiplication.setOnClickListener(this)
        binding.btDivision.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val math1 = binding.etMath1.text.toString()
        val math2 = binding.etMath2.text.toString()
        var check = 0

        if (math1.equals("") || math2.equals("")) {
            Snackbar.make(v, "数値１または数値２が未入力です", Snackbar.LENGTH_INDEFINITE).show()
        }else{
            val intent = Intent(this, EditText::class.java)
            intent.putExtra("VALUE1", math1.toDouble())
            intent.putExtra("VALUE2", math2.toDouble())
            when (v.id) {
                R.id.btSum -> intent.putExtra("VALUE3",1)
                R.id.btSubtraction -> intent.putExtra("VALUE3",2)
                R.id.btMultiplication -> intent.putExtra("VALUE3",3)
                R.id.btDivision -> {
                    if(math2.equals("0") || math2.equals("0.0")){
                        check = 1
                    }else{
                        intent.putExtra("VALUE3",4)
                    }
                }
            }
            if(check == 0){
                startActivity(intent)
            }else{
                Snackbar.make(v, "0での割り算はできません。", Snackbar.LENGTH_INDEFINITE).show()
            }
        }
    }
}