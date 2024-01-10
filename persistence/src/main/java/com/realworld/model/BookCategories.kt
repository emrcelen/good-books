package com.realworld.model

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity(name = "BookCategories")
@Table(name = "bookcategory")
data class BookCategories(
    val categoryName: String?,
    val bookCategory: Set<Book>
)
