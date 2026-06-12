package com.turkcell.lyraapp.data.model

data class Playlist(
    val id: String,
    val title: String,
    val description: String = "",
    val imageUrl: String,
    val songCount: Int = 0,
    val author: String = ""
)
