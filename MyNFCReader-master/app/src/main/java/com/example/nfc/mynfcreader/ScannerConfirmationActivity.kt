package com.example.nfc.mynfcreader

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ScannerConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner_confirmation)
        val button = findViewById<ImageView>(R.id.profile)
        button.setOnClickListener {
            openLevel()
            // do something when the corky is clicked
        }

    }
    private fun openLevel() {
        val intent = Intent(this, LevelActivity::class.java)
        startActivity(intent)
    }
}
