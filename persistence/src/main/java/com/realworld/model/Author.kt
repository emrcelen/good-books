package com.realworld.model

import jakarta.persistence.*

@Entity(name = "Author")
@Table(name = "author", schema = "good_books")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    var authorName: String?,
    var authorSurname: String?
) {
    protected constructor() : this(Builder())

    private constructor(builder: Builder) : this(
        null,
        builder.authorName,
        builder.authorSurname
    )

    class Builder {
        var id: Long? = null
            private set
        var authorName: String? = ""
            private set
        var authorSurname: String? = ""
            private set

        fun id(id: Long) = apply { this.id = id }
        fun authorName(authorName: String) = apply { this.authorName = authorName }
        fun authorSurname(authorSurname: String) = apply { this.authorSurname = authorSurname }
        fun build() = Author(this)
    }
}
