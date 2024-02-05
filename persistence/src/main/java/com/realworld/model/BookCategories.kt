package com.realworld.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity(name = "BookCategories")
@Table(name = "bookcategory", schema = "good_books")
data class BookCategories(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    val id: Long?,
    @Column(unique = true)
    val categoryName: String?,
    @ManyToMany(mappedBy = "categories")
    var bookCategory: Set<Book>?
) {
    protected constructor() : this(Builder())

    private constructor(builder: Builder) : this(
        builder.id,
        builder.categoryName,
        builder.bookCategory
    )

    class Builder {
        var id: Long? = null
            private set
        var categoryName: String? = ""
            private set
        var bookCategory: Set<Book>? = null
            private set

        fun id(id: Long?) = apply { this.id = id }
        fun categoryName(categoryName: String) = apply { this.categoryName = categoryName }
        fun bookCategory(bookCategory: Set<Book>) = apply { this.bookCategory = bookCategory }
        fun build() = BookCategories(this)
    }
}
