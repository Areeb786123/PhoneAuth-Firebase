package com.areeb.phoneauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_phoneauth.*
const val PHONE_NUMBER="phone"

class phoneauth : AppCompatActivity() {

    val phoneNoEt:EditText by lazy {
        findViewById<EditText>(R.id.enter_phonenumber)
    }
    val button: Button by lazy {
        findViewById<Button>(R.id.get_otp)
    }


    lateinit var phonenumber:String
    lateinit var selected_country:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phoneauth)


        phoneNoEt.addTextChangedListener { value ->

            button.isEnabled  = !(value.isNullOrEmpty() || value.length < 10 )



        }

        get_otp.setOnClickListener {
            CheckNumber()
        }

    }

    private fun CheckNumber(){
      selected_country = country_code.selectedCountryCodeWithPlus
        phonenumber= selected_country + enter_phonenumber.text.toString()

        //add some validation here

        startActivity(Intent(this,otp_activity::class.java).putExtra(PHONE_NUMBER ,phonenumber))



    }
}