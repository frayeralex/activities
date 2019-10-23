package com.github.frayeralex.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

const val REQUEST_CODE = 10;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openSecondScreen(view: android.view.View): Unit {
        startSecondActivity()
    }

    private fun startSecondActivity() {
        val indent = Intent(this, SecondActivity::class.java)
        startActivity(indent)
    }

    fun openSecondScreenForResult(view: android.view.View): Unit {
        startSecondActivityForResult()
    }

    private fun startSecondActivityForResult() {
        val indent = Intent(this, SecondActivity::class.java)
        startActivityForResult(indent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            if (data is Intent && data.hasExtra("BAR")) {
                Toast.makeText(this, data.extras?.getString("BAR"), Toast.LENGTH_SHORT).show()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}