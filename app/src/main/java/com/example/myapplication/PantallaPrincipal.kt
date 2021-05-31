package com.example.myapplication
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent


class PantallaPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.pantallaprincipal)

        findViewById<Button>(R.id.enter).setOnClickListener {
            val intentLogin = Intent(this, Menu::class.java).apply {}
            startActivity(intentLogin)
        }
    }


}






