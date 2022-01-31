package com.example.intent

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img1.setOnClickListener{
            val intent_details=Intent(this,DetailsActivity::class.java)
            intent_details.putExtra("title",title1.text)
            //startActivity(intent_details)
            getResult.launch(intent_details)

        }

    }

   private val getResult=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
       if(it.resultCode==Activity.RESULT_OK){
           Toast.makeText(this,it.data?.getStringExtra("result"),Toast.LENGTH_LONG).show()
       }
   }
}