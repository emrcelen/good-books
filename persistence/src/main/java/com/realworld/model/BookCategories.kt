package com.realworld.model

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity(name = "BookCategories")
@Table(name = "bookcategory", schema = "good_books")
data class BookCategories(
    var categoryName: String?,
    var bookCategory: Set<Book>?
) {
    protected constructor() : this(Builder())

    private constructor(builder: Builder) : this(
        builder.categoryName,
        builder.bookCategory
    )

    class Builder {
        var categoryName: String? = ""
            private set
        var bookCategory: Set<Book>? = null
            private set
    }

    fun categoryName(categoryName: String) = apply { this.categoryName = categoryName }
    fun bookCategory(bookCategory: Set<Book>) = apply { this.bookCategory = bookCategory }
}
