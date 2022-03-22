package com.example.ayyan.data.remote.dto

import com.example.ayyan.domain.model.MovieData

data class MovieDto(
    val category: String,
    val desc: String,
    val imageUrl: String,
    val name: String
)

fun MovieDto.toModelData(): MovieData {
    return MovieData(
        category = category,
        desc = desc,
        imageUrl = imageUrl,
        name = name
    )
}