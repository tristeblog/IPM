package com.example.myapplication
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MyIncidences : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myincidences)
        var openedissues= savedInstanceState?.getStringArrayList("opennedIssues");
        

        if(openedissues == null) {
            openedissues = ArrayList<String>();
        }

        val newIssue = intent.extras?.get("newissue");
        if (newIssue != null) {
            val code = newIssue as String;
            val textView = TextView(this);
            textView.setText("issue 3\n Code: $code");
            openedissues.add(code);
        }

        var count = 0;
        for(issue in openedissues) {
            val textView = TextView(this);
            textView.setText("issue ${++count} 3\n Code: $newIssue");
            findViewById<LinearLayout>(R.id.incidences).addView(textView);
        }

        savedInstanceState?.putStringArrayList("openedIssues", openedissues);

        findViewById<Button>(R.id.retMenu).setOnClickListener {
            val intentLogin = Intent(this, Menu::class.java).apply {}
            startActivity(intentLogin)
        }
    }

}