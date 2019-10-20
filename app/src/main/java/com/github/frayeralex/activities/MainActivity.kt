package com.github.frayeralex.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun openSecondScreen(view: android.view.View): Unit {
        startSecondActivity()
    }

    private fun startSecondActivity() {
        val indent = Intent(this, Second::class.java)
        startActivity(indent)
    }
}