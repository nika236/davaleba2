package com.example.firebaseappbtu1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var emailForResetEditText: EditText
    private lateinit var resetPasswordButton: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)
        listeners()
        init()
    }

    private fun listeners() {


        resetPasswordButton.setOnClickListener {
            val email = emailForResetEditText.text.toString()

            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Reset password email sent.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Failed to send reset password email.", Toast.LENGTH_SHORT).show()
                    }
                }
        }


    }
    private fun init(){
        emailForResetEditText = findViewById(R.id.emailForResetEditText)
        resetPasswordButton = findViewById(R.id.resetPasswordButton)
        auth = FirebaseAuth.getInstance()
    }
}