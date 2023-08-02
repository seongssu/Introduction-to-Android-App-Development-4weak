package com.android.activityintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class FirstActivity : AppCompatActivity() {
    val TAG = "FirstActivity_Lifrcycle"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btn = findViewById<Button>(R.id.btnFirstActivity)
        btn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        val btn_call3 = findViewById<Button>(R.id.btnThirdActivity)
        btn_call3.setOnClickListener {
            val edit_Text = findViewById<EditText>(R.id.edit_data)
            val strData = edit_Text.text.toString()
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("dataFromFirstActivity", strData)
            startActivity(intent)
        }
        Log.i(TAG, "onCreate()")
    }


    fun doOnBtnClick(v: View){
        when(v.getId()){
            R.id.btnDialActivity -> {
                val call_intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:114"))
                startActivity(call_intent)
            }
            R.id.btnMapActivity -> {
                val map_intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.565350, 127.01445"))
                startActivity(map_intent)
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy()")
    }
}

