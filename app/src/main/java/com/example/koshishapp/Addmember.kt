package com.example.koshishapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.VolleyLog
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject


class Addmember : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addmember)

        val name = findViewById<TextView>(R.id.member_name);
        val yoj = findViewById<TextView>(R.id.joining_year);
        val email = findViewById<TextView>(R.id.email);
        val phone = findViewById<TextView>(R.id.phone);
        val location = findViewById<TextView>(R.id.location);
        val admin = findViewById<TextView>(R.id.admin);
        val respon = findViewById<TextView>(R.id.respons);
        val sunday = findViewById<TextView>(R.id.sunday);
        val monday = findViewById<TextView>(R.id.monday);
        val tuesday = findViewById<TextView>(R.id.tuesday);
        val wednesday = findViewById<TextView>(R.id.wednesday);
        val thursday = findViewById<TextView>(R.id.thursday);
        val friday = findViewById<TextView>(R.id.friday);
        val saturday = findViewById<TextView>(R.id.saturday);

        val text1 = findViewById<TextView>(R.id.textbox2);
        val markButton = findViewById<Button>(R.id.mark_button);
        val url = "https://b8904a773750.ngrok.io/add_new_member";



        /* markButton.setOnClickListener{
            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the test in te toast msz
                    text1.text = response },
                Response.ErrorListener { text1.text = "That didn't work!" })
            queue.add(stringRequest)
        } */

        markButton.setOnClickListener {
            // val queue = Volley.newRequestQueue(this);
            val jsonData = JSONObject().apply {
                put("NAME", name.text.toString())
                put("YEAR_OF_JOINING", yoj.text.toString().toInt())
                put("EMAIL", email.text.toString())
                put("PHONE", phone.text.toString().toLong())
                put("LOCATION", location.text.toString())
                put("IS_ADMIN", admin.text.toString().toInt())
                put("RESPONSIBILITY", respon.text.toString())
                put("SUNDAY", sunday.text.toString().toInt())
                put("MONDAY", monday.text.toString().toInt())
                put("TUESDAY", tuesday.text.toString().toInt())
                put("WEDNESDAY", wednesday.text.toString().toInt())
                put("THURSDAY", thursday.text.toString().toInt())
                put("FRIDAY", friday.text.toString().toInt())
                put("SATURDAY", saturday.text.toString().toInt())
            }

            val requestJson = JsonObjectRequest(url, jsonData,
                {
                    try {
                        Log.e("response", it.toString())
                        Toast.makeText(this, name.text.toString() + " Added", Toast.LENGTH_LONG).show();
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            ) { error -> VolleyLog.e("Error: ", error.message) }
            Volley.newRequestQueue(this).add(requestJson)

        }
    }
}