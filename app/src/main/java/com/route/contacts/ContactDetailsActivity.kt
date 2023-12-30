package com.route.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class ContactDetailsActivity : AppCompatActivity() {

    lateinit var name: TextView
    lateinit var phone: TextView
    lateinit var description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        var contactName = intent.getStringExtra("name")
        var contactPhone = intent.getStringExtra("phone")
        var contactDescription = intent.getStringExtra("description")

        name = findViewById(R.id.detailsNameTV)
        phone = findViewById(R.id.detailsPhoneTV)
        description = findViewById(R.id.detailsDescriptionTV)

        name.text = contactName
        phone.text = contactPhone
        description.text = contactDescription

    }
}