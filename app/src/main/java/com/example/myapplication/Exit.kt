package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Exit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.exit)

        findViewById<Button>(R.id.new_rep).setOnClickListener {
            val intentLogin = Intent(this, MyIncidences::class.java).apply {}
            startActivity(intentLogin)
        }

        findViewById<Button>(R.id.menu_exit).setOnClickListener {
            val intentLogin = Intent(this, Menu::class.java).apply {}
            startActivity(intentLogin)
        }


    }

}