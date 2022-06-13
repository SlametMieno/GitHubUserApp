package com.mieno.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitUser(
    var u_name: String,
    var u_name_desc: String,
    var u_avatar: Int,
    var u_follower: Int,
    var u_following: Int,
    var u_company: String,
    var u_location: String,
    var u_repository: String
):Parcelable
