package com.example.myapplication
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.widget.Button
import android.content.Intent
import android.widget.ImageButton


class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.menu)

        findViewById<Button>(R.id.myincd).setOnClickListener {
            val intentLogin = Intent(this, MyIncidences::class.java).apply {}
            startActivity(intentLogin)
        }

        findViewById<Button>(R.id.myincd2).setOnClickListener {
            val intentLogin = Intent(this, ReportIncidence1::class.java).apply {}
            startActivity(intentLogin)
        }
    }


}