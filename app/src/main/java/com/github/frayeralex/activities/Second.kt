package com.github.frayeralex.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_second.*

class Second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)
    }

    fun openMailApp(view: View) {
        composeEmail("Mail subject")
    }

    private fun composeEmail(subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun sendResultBackHandler(view: View) {
        finish()
    }

    override fun finish() {
        val intent = Intent().apply {
            putExtra("BAR", "BAR")
        }
        setResult(Activity.RESULT_OK, intent)
        super.finish()
    }

}
