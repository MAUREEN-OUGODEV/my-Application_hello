package com.techmania.pluralapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var tvLogin: TextView
    lateinit var btnSign: Button
    lateinit var tilFirstName: TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var tilLastName: TextInputLayout
    lateinit var etLastName: TextInputEditText
    lateinit var tilEmail: TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var tilPassword: TextInputLayout
    lateinit var etPassword: TextInputEditText
    lateinit var tilPasswordConf: TextInputLayout
    lateinit var etPasswordConf: TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()

    }

    override fun onResume() {
        super.onResume()
        tvLogin.setOnClickListener {
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)

        }
        btnSign.setOnClickListener {
            validateSign()
        }
    }

    fun castViews() {
        tvLogin = findViewById(R.id.tvLogin)
        btnSign = findViewById(R.id.btnsign)
        tilFirstName = findViewById(R.id.tilFirstName)
        tilLastName = findViewById(R.id.tilLastName)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassWord)
        tilPasswordConf = findViewById(R.id.tilConfPassword)
        etFirstName = findViewById(R.id.etFirsttName)
        etLastName = findViewById(R.id.etLastName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassWord)
        etPasswordConf = findViewById(R.id.etConfPassword)



    }
    fun validateSign(){
        tilFirstName.error = null
        val firstName = etFirstName.text.toString()
        val lastName = etLastName.text.toString()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val passwordConf=etPasswordConf.text.toString()
        var error =false

        if(firstName.isBlank()){
            tilFirstName.error = "First name required"
            error = true
        }
        if(lastName.isBlank()){
            tilLastName.error="Last name requred"
            error = true
        }
        if(email.isBlank()){
            tilEmail.error = "First name required"
            error = true
        }
        if(password.isBlank()){
            tilPassword.error = "First name required"
            error = true
        }
        if(passwordConf.isBlank()){
            tilPasswordConf.error = "First name required"
            error = true
        if(password!=passwordConf) {
            tilPasswordConf.error = "password invalid"
        }
        }
       if(!error){
          Toast
              .makeText(this, "$firstName  $lastName $email", Toast.LENGTH_LONG).show()
       }
    }
}