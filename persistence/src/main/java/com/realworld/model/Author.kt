package com.realworld.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity(name = "Author")
@Table(name = "author", schema = "good_books")
data class Author(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "author_id")
    val id: UUID?,
    var authorName: String?,
    var authorSurname: String?,
    @ManyToMany(mappedBy = "authors")
    var books: Set<Book>?,
) {
    protected constructor() : this(Builder())

    private constructor(builder: Builder) : this(
        null,
        builder.authorName,
        builder.authorSurname,
        builder.books
    )

    class Builder {
        var authorName: String? = ""
            private set
        var authorSurname: String? = ""
            private set
        var books: Set<Book>? = null
            private set

        fun authorName(authorName: String) = apply { this.authorName = authorName }
        fun authorSurname(authorSurname: String) = apply { this.authorSurname = authorSurname }
        fun books(book:Set<Book>) = apply { this.books = books }
        fun build() = Author(this)
    }
}
