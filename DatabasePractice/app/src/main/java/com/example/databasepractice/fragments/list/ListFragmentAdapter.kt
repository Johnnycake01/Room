package com.example.databasepractice.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.databasepractice.R
import com.example.databasepractice.database.model.User

class ListFragmentAdapter : RecyclerView.Adapter<ListFragmentAdapter.ViewHolderList>() {
    private var itemList = emptyList<User>()

    inner class ViewHolderList(v: View) : RecyclerView.ViewHolder(v) {
        val userId: TextView = v.findViewById(R.id.tvId)
        val firstName: TextView = v.findViewById(R.id.tvFirstName)
        val lastName: TextView = v.findViewById(R.id.tvLastNameInput)
        val userAge: TextView = v.findViewById(R.id.tvAgeInput)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_fragment_recyclerview_item_layout, parent, false)
        return ViewHolderList(view)
    }

    override fun onBindViewHolder(holder: ViewHolderList, position: Int) {
        val itemListPosition = itemList[position]
        holder.userId.text = itemListPosition.id.toString()
        holder.firstName.text = itemListPosition.firstName
        holder.lastName.text = itemListPosition.lastName
        holder.userAge.text = itemListPosition.age.toString()
        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(itemListPosition)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun addToList(user: List<User>) {
        this.itemList = user
        notifyDataSetChanged()
    }
}