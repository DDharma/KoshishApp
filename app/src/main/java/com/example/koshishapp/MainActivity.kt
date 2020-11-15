package com.example.koshishapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bganim = AnimationUtils.loadAnimation(this, R.anim.bganim);
        //val open_amin = AnimationUtils.loadAnimation(this, R.id.ma)

        val bgapp = findViewById<ImageView>(R.id.main_bg);
        val bgicon = findViewById<ImageView>(R.id.main_icon);
        val textsplace = findViewById<LinearLayout>(R.id.greeting_text);
        val opningtext = findViewById<LinearLayout>(R.id.opening_text);
        val openIcon = findViewById<LinearLayout>(R.id.opening_item);

        bgapp.animate().translationY((-1050).toFloat()).setDuration(900).startDelay = 300;
        bgicon.animate().translationY(100F).setDuration(600).startDelay = 600;
        textsplace.animate().translationY(200F).alpha(0F).setDuration(1000).startDelay = 600;
        opningtext.startAnimation(bganim);
        openIcon.startAnimation(bganim);

        // Moving from the MainActivity to loginActivity
        // All image variable
        val kLogo = findViewById<ImageView>(R.id.main_icon)
        val pathsala = findViewById<ImageView>(R.id.pathsala)
        val kure = findViewById<ImageView>(R.id.kure)
        val event = findViewById<ImageView>(R.id.event)
        val finance = findViewById<ImageView>(R.id.finance)

        // All listener
        kLogo.setOnClickListener{
            Toast.makeText(this, "Welocom to the koshish is click", Toast.LENGTH_LONG).show()
        }

        pathsala.setOnClickListener{
            //Toast.makeText(this, "Pathsala is click", Toast.LENGTH_LONG).show()
            val deptName = "PATHSHALA";
            //val intent: Intent = Intent(applicationContext,LoginActivity::class.java);
            val intent: Intent = Intent(this@MainActivity,LoginActivity::class.java);
            intent.putExtra("DeptName",deptName);
            startActivity(intent);
        }

        kure.setOnClickListener{
            //Toast.makeText(this, "Kure is click", Toast.LENGTH_LONG).show()
            val deptName = "KURE";
            //val intent: Intent = Intent(applicationContext,LoginActivity::class.java);
            val intent: Intent = Intent(this@MainActivity,LoginActivity::class.java);
            intent.putExtra("DeptName",deptName);
            startActivity(intent);
        }

        event.setOnClickListener{
            //Toast.makeText(this, "event is click", Toast.LENGTH_LONG).show()
            val deptName = "EVENT-CRAFTER";
            //val intent: Intent = Intent(applicationContext,LoginActivity::class.java);
            val intent: Intent = Intent(this@MainActivity,LoginActivity::class.java);
            intent.putExtra("DeptName",deptName);
            startActivity(intent);
        }

        finance.setOnClickListener{
            //Toast.makeText(this, "finance is click", Toast.LENGTH_LONG).show()
            val deptName = "FINANCE";
            //val intent: Intent = Intent(applicationContext,LoginActivity::class.java);
            val intent: Intent = Intent(this@MainActivity,LoginActivity::class.java);
            intent.putExtra("DeptName",deptName);
            startActivity(intent);
        }


    }
}