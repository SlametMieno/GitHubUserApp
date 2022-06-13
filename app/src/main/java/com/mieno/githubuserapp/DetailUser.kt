package com.mieno.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class DetailUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val tvUsername: TextView = findViewById(R.id.tv_data_username)
        val tvNameDesc: TextView = findViewById(R.id.tv_data_name)
        val ivAvatar: ImageView = findViewById(R.id.iv_data_avatar)
        val tvFollower: TextView = findViewById(R.id.tv_follower)
        val tvFollowing: TextView = findViewById(R.id.tv_following)
        val tvCompany: TextView = findViewById(R.id.tv_company)
        val tvLocation: TextView = findViewById(R.id.tv_location)
        val tvRepository: TextView = findViewById(R.id.tv_repository)

        val dataDetail = intent.getParcelableExtra<GitUser>("DATA")
        if (dataDetail != null) {
            ivAvatar.setImageResource(dataDetail.u_avatar)
        }
        tvUsername.text = dataDetail?.u_name
        tvNameDesc.text = dataDetail?.u_name_desc
        tvFollower.text = "Follower : " + dataDetail?.u_follower
        tvFollowing.text = "Following : " + dataDetail?.u_following
        tvCompany.text = "Company : " + dataDetail?.u_company
        tvLocation.text = "Location : " + dataDetail?.u_location
        tvRepository.text = "Repository : " + dataDetail?.u_repository
    }
}