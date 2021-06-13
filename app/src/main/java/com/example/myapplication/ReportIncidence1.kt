package com.example.myapplication
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.zxing.integration.android.IntentIntegrator


class ReportIncidence1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.reportincidence1)

        findViewById<Button>(R.id.cambutton).setOnClickListener {
            Toast.makeText(this, "Opening the camera...", Toast.LENGTH_SHORT);
            if(ContextCompat.checkSelfPermission(applicationContext, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                val integrator = IntentIntegrator(this);
                //SI QUEREIS METER PROPIEDADES AL SCANER VAN AQUI
                integrator.initiateScan();
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 5);
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            val content = result.contents;
            //ESTE CONTENT TIENE EL CONTENIDO DEL QR
            Toast.makeText(this, content, Toast.LENGTH_LONG);
            val viewer = findViewById<TextView>(R.id.textv);
            //viewer.setText(content);
            val issuesScreen = Intent(this, ReportIncidence2::class.java);
            issuesScreen.putExtra("light", content);
            startActivity(issuesScreen);
        } else {
            Toast.makeText(this, "Unknown QR", Toast.LENGTH_SHORT).show();
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == 5) {
            if(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }
}