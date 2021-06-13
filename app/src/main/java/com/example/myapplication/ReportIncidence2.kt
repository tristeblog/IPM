package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class ReportIncidence2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.reportincidence2)
        val light = intent.extras?.get("light");

        findViewById<Button>(R.id.goToIncidents).setOnClickListener {
            val intent = Intent(this, MyIncidences::class.java);
            intent.putExtra("newissue", light as String);
            startActivity(intent);
        }

        findViewById<EditText>(R.id.text_other).setOnClickListener {
            findViewById<EditText>(R.id.text_other).setText("");
        }

        findViewById<ImageButton>(R.id.rp2next).setOnClickListener {
            //val intentLogin = Intent(this, Menu::class.java).apply {}
            findViewById<TextView>(R.id.textito).setText(light as String);
            //startActivity(intentLogin)

            val issueID = findViewById<RadioGroup>(R.id.issue).checkedRadioButtonId;

            var report = "";
            if(issueID != R.id.other) {
                report = findViewById<RadioButton>(issueID).text as String;
            } else {

                val editText = findViewById<EditText>(R.id.text_other);
                report = editText.text.toString();
                editText.setText("");
            }


            val map = HashMap<String, String>();
            map.set("name", "yo");
            map.set("message", "Reportada una incidencia $report en la farola $light")

            findViewById<TextView>(R.id.textView6).setText(map.get("message"))

            val json = JSONObject(map as Map<*, *>);

            val queue = Volley.newRequestQueue(this);
            val url = "https://formsubmit.co/sandra.rodriguez06@estudiant.upf.edu";
            val postRequest = JsonObjectRequest(Request.Method.POST, url, json,
                { response ->
                    Toast.makeText(this, "Peticion enviada", Toast.LENGTH_LONG).show();
                },
                {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            )

            queue.add(postRequest);
        }
    }
}