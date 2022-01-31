package com.example.intent

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val data=intent.extras
        if (data!=null){
            val message=data.getString("title")
            Toast.makeText(this,message,Toast.LENGTH_LONG).show()
            btn.setOnClickListener{
                val return_result=this.intent
                return_result.putExtra("result","return Result from Details page")
                setResult(Activity.RESULT_OK,return_result)
                finish()
            }
        }
    }
}