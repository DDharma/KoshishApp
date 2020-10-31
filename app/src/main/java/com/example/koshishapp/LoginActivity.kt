package com.example.koshishapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Animation XML
        val bganim = AnimationUtils.loadAnimation(this, R.anim.loginanim);

        // Logo variable
        var k_logo = findViewById<ImageView>(R.id.KLogo);
        var username = findViewById<TextView>(R.id.username);
        var password = findViewById<TextView>(R.id.password);
        var k_logo3 = findViewById<TextView>(R.id.dept_welcome);
        var loginButton = findViewById<ImageView>(R.id.loginButton);
        k_logo.startAnimation(bganim);
        username.startAnimation(bganim);
        password.startAnimation(bganim);
        k_logo3.startAnimation(bganim);
        loginButton.startAnimation(bganim);


        var dept_welcome = findViewById<TextView>(R.id.dept_welcome);
        var intent = intent;
        var deptName = intent.getStringExtra("DeptName")

        dept_welcome.text = "HEY"+"\n ENTER YOUR CREADENTIALS" + "\nTO MOVE IN\n KOSHISH " + deptName;



        //Credentials validation
        loginButton.setOnClickListener{
            if(username.text.toString() == password.text.toString()) {

                val intent: Intent = Intent(this@LoginActivity,Attendence::class.java);
                startActivity(intent);
                Toast.makeText(this, "Welcome to login", Toast.LENGTH_LONG).show();

            }
            else{
                Toast.makeText(this, "Please, Check Your USER-NAME and PASSWORD", Toast.LENGTH_LONG).show();
            };
        }
    }
}