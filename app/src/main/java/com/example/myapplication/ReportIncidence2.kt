package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment



class ReportIncidence2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.reportincidence2)

        findViewById<ImageButton>(R.id.rp2next).setOnClickListener {
            val intentLogin = Intent(this, Menu::class.java).apply {}
            startActivity(intentLogin)
        }
    }
}