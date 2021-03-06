package com.example.homebmi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContract
import com.example.homebmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var TAG = MainActivity::class.java.simpleName
    val REQUEST_DISPLAY_BMI = 16
    var launcher = registerForActivityResult(NameContract()){
       name ->
        Log.d(TAG, "$name")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun btn_click(view:View){
//        val nameOne = binding.txName.text.toString()
        val nameOne : Float= 11.1f
        println(nameOne)
//        val intent = Intent(this, OneActivity::class.java)
//        //intent.putExtra("BMI", bmi)
//        startActivity(intent)
        launcher.launch(nameOne)
    }

    //活動結果合同
    class NameContract : ActivityResultContract<Float,String>(){
        //介面方法重寫
//        每个 ActivityResultContract 都需要定义输入和输出类，如果您不需要任何输入，
//        可使用 Void（在 Kotlin 中，使用 Void? 或 Unit）作为输入类型。
        override fun createIntent(context: Context, input: Float?): Intent {
            //Extra 裡面跟 Map 一樣是以 <key, value> 的形式儲存。
            // 字串都是 String? 型態，也就是有可能為空。在使用上記得加上濾空
            var intent  = Intent(context,OneActivity::class.java)
                .putExtra("NAME",input)
            return intent
        }

        override fun parseResult(resultCode: Int, intent: Intent?): String {

            if(resultCode == RESULT_OK){
                //相當於獲取key
                    println("解析one 在1")
                var name = intent?.getStringExtra("NAME")
                return name!!
            }else{
                return "no name!"
            }
        }
    }
    //ctrl + o
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 16 && resultCode == RESULT_OK){

        }
    }
}