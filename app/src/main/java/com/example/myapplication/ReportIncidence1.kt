package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment



class ReportIncidence1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.reportincidence1)

        findViewById<ImageButton>(R.id.rp1next).setOnClickListener {
            val intentLogin = Intent(this, ReportIncidence2::class.java).apply {}
            startActivity(intentLogin)
        }
    }
}