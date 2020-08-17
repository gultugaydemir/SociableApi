package com.example.sociableapi

import java.io.Serializable

data class Repository(
    val author: String,
    val title: String,
    val url: String,
    val description: String,
    val language: String,
    val stars: Int,
    val forks: Int,
    val currentPeriodStars: Int,
    val user: User? = null): Serializable