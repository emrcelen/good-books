package com.realworld.model

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity(name = "Author")
@Table(name = "author")
data class Author(
    val authorName: String?,
    val authorSurname: String?
)
