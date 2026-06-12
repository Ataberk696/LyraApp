package com.turkcell.lyraapp.data.model

data class Song(
    val id: String,
    val title: String,
    val artist: String,
    val imageUrl: String,
    val duration: Long = 0L,
    val isLiked: Boolean = false
)
