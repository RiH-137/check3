package com.example.kishaanmadad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {

    lateinit var database:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        /* val log_btn=findViewById<TextView>(R.id.login_page1)

        log_btn.setOnClickListener{
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }*/

        val log: TextView? = findViewById(R.id.login_page1)
        if (log != null) {
            log.setOnClickListener{
                val intent= Intent(this, LoginActivity::class.java)
                startActivity(intent)


                val signButton = findViewById<Button>(R.id.signupBtn)
                val etname = findViewById<TextInputLayout>(R.id.name)
                val etemail = findViewById<TextInputLayout>(R.id.email)
                val etpassword = findViewById<TextInputLayout>(R.id.password)


                signButton.setOnClickListener {
                    val UserName = etname.editText?.text.toString().trim()
                    val email = etemail.editText?.text.toString().trim()
                    val password = etpassword.editText?.text.toString().trim()

                    if (UserName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                        Toast.makeText(
                            this@SignupActivity,
                            "Please fill in all required information",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val user=User(UserName, email,password)
                        database= FirebaseDatabase.getInstance().getReference("Users")
                        database.child(UserName).setValue(user).addOnSuccessListener {
                            Toast.makeText(this, "Registration Successful...", Toast.LENGTH_SHORT).show()
                        }.addOnSuccessListener {
                            Toast.makeText(this,"Failed! Please try again...", Toast.LENGTH_SHORT).show()
                        }

                    }
                }
            }
        }
    }
}