package com.mieno.githubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvGitUser: RecyclerView
    private var list = ArrayList<GitUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGitUser = findViewById(R.id.rv_git_user)
        rvGitUser.setHasFixedSize(true)

        list.addAll(listGitUser)
        showRecyclerList()
    }

    private val listGitUser:ArrayList<GitUser> get() {
        val username = resources.getStringArray(R.array.username)
        val name = resources.getStringArray(R.array.name)
        val avatar = resources.obtainTypedArray(R.array.avatar)
        val follower = resources.getStringArray(R.array.followers)
        val following = resources.getStringArray(R.array.following)
        val company = resources.getStringArray(R.array.company)
        val location = resources.getStringArray(R.array.location)
        val repository = resources.getStringArray(R.array.repository)

        val listUser = ArrayList<GitUser>()

        for( i in username.indices){
            val gitUser = GitUser(username[i], name[i], avatar.getResourceId(i,-1), follower[i].toInt(), following[i].toInt(), company[i], location[i], repository[i])
            listUser.add(gitUser)
        }
        return listUser
    }

    private fun showRecyclerList() {
        rvGitUser.layoutManager = LinearLayoutManager(this)
        val listGUser = ListGitUserAdapter(list)
        rvGitUser.adapter = listGUser

        listGUser.setOnItemClickCallback(object : ListGitUserAdapter.OnItemClickCallback{
            override fun onItemClickData(data: GitUser) {
               //showSelectedUser(data)

                val pageDetail = Intent(this@MainActivity, DetailUser::class.java)
                pageDetail.putExtra("DATA", data)
                startActivity(pageDetail)
            }
        })
    }

    private fun showSelectedUser(user:GitUser){
        Toast.makeText(this,"Kamu memilih user " + user.u_name, Toast.LENGTH_SHORT).show()
    }
}