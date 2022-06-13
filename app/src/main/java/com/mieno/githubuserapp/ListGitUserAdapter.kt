package com.mieno.githubuserapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class ListGitUserAdapter(private val listUser:ArrayList<GitUser>):RecyclerView.Adapter<ListGitUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback



    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var avatar: ImageView = itemView.findViewById(R.id.item_avatar)
        var username : TextView = itemView.findViewById(R.id.tv_user_name)
        var name_desc: TextView = itemView.findViewById(R.id.tv_name_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListGitUserAdapter.ListViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_avatar, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListGitUserAdapter.ListViewHolder, position: Int) {
        val(username, name_desc, avatar) = listUser[position]
        holder.avatar.setImageResource(avatar)
        holder.username.text = username
        holder.name_desc.text = name_desc

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClickData(listUser[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int  = listUser.size

    interface OnItemClickCallback {
        fun onItemClickData(data: GitUser)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
}