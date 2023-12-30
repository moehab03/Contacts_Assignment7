package com.route.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class ContactsAdapter(private var contacts: ArrayList<ContactsDM>) : Adapter<ContactsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.nameTv)
        var phone = itemView.findViewById<TextView>(R.id.phoneTv)
    }

    fun interface onItemCLick{
        fun onClick(contact: ContactsDM)
    }

    private lateinit var onItemClick : onItemCLick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        )
    }

    override fun getItemCount(): Int = contacts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contact = contacts[position]

        holder.name.text = contact.name
        holder.phone.text = contact.phone

        holder.itemView.setOnClickListener {
            onItemClick.onClick(contact)
        }

    }

}
