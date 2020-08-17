package com.example.sociableapi

data class User(
    val name: String,
    val avatar: String,
    val href: String)

val DEFAULT_USER: User = User("", "", "")