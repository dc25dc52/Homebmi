package com.example.homebmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.homebmi.databinding.ActivityOneBinding

class OneActivity : AppCompatActivity() {
    var TAG = OneActivity::class.java.simpleName
        lateinit var binding : ActivityOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOneBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

            //獲取one傳來的值
            var name = intent.getStringExtra("NAME")
            Log.d(TAG, "two: $name")

        binding.btnTwo.setOnClickListener {
            var name = binding.textTwoname.text.toString()
            var data = Intent()
            data.putExtra("NAME",name)
            //設定ok 並且傳送數據
            setResult(RESULT_OK,data)
            ////取消鍵就調用 finish() 方法
            finish()

        }



    }
}