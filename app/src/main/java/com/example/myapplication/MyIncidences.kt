package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment



class MyIncidences : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.myincidences)

        findViewById<Button>(R.id.mimenu).setOnClickListener {
            val intentLogin = Intent(this, Menu::class.java).apply {}
            startActivity(intentLogin)
        }
    }
}