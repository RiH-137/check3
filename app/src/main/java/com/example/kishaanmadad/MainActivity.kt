package com.example.kishaanmadad

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor= Color.TRANSPARENT
        Toast.makeText(this, "Welcome...", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed({
            if (FirebaseDatabase.getInstance().CurrentUser != null) {
                // The user is already logged in, so redirect to the home activity
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                // The user is not logged in, so redirect to the sign up activity
                startActivity(Intent(this, SignupActivity::class.java))
                finish()
         //   }
        },3000)
    }
}