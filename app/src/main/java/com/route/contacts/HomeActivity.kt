package com.route.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    var contacts: ArrayList<ContactsDM> = ArrayList()
    lateinit var adapter: ContactsAdapter

    lateinit var nameEt: EditText
    lateinit var phoneEt: EditText
    lateinit var descriptionEt: EditText
    lateinit var saveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.recyclerView)
        nameEt = findViewById(R.id.nameET)
        phoneEt = findViewById(R.id.phoneET)
        descriptionEt = findViewById(R.id.descriptionET)
        saveBtn = findViewById(R.id.saveBtn)

        saveBtn.setOnClickListener {
            addNewContact()
        }
    }

    private fun addNewContact() {
        if (nameEt.text.toString().length < 3)
            Toast.makeText(this, "Name should be more than 3 characters ", Toast.LENGTH_SHORT)
                .show()
        else if (phoneEt.text.toString().length != 11)
            Toast.makeText(this, "Number should be 11 digit", Toast.LENGTH_SHORT).show()
        else {
            contacts.add(
                ContactsDM(
                    name = nameEt.text.toString(),
                    phone = phoneEt.text.toString(),
                    description = descriptionEt.text.toString()
                )
            )
            clearAllEditTexts()
            updateRecyclerView()
        }
    }

    private fun clearAllEditTexts(){
        nameEt.setText("")
        phoneEt.setText("")
        descriptionEt.setText("")
    }

    private fun updateRecyclerView(){
        adapter = ContactsAdapter(contacts)
        adapter.onItemClick = ContactsAdapter.onItemCLick{contact ->
            startDetailsActivity(contact)
        }
        recyclerView.adapter = adapter
    }

    private fun startDetailsActivity(contact: ContactsDM) {
        val intent = Intent(this, ContactDetailsActivity::class.java)
        intent.putExtra("name", contact.name)
        intent.putExtra("phone", contact.phone)
        intent.putExtra("description", contact.description)
        startActivity(intent)
    }
}

