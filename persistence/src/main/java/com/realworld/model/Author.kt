package com.realworld.model

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity(name = "Author")
@Table(name = "author", schema = "good_books")
data class Author(
    var authorName: String?,
    var authorSurname: String?
){
    protected constructor() : this(Builder())

    private constructor(builder: Builder) : this(
        builder.authorName,
        builder.authorSurname
    )

    class Builder {
        var authorName: String? = ""
            private set
        var authorSurname: String? = ""
            private set
    }

    fun authorName(authorName: String) = apply { this.authorName = authorName }
    fun authorSurname(authorSurname: String) = apply { this.authorSurname = authorSurname }

}
