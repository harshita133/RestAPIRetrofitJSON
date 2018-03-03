package com.developer.harshi.restapiretrofitjson.Models

import android.support.v4.app.INotificationSideChannel

/**
 * Created by Harshi on 6/29/2017.
 */
data class Comment(
        val postId: Int,
        val id: Int,
        val name: String,
        val email: String,
        val body: String
)