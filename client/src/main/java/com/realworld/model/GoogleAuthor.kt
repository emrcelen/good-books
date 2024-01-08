package com.realworld.model

data class GoogleAuthor(
    val name: String,
    val surname: String,
) {
    private constructor(builder: Builder) : this(builder.name, builder.surname)

    class Builder {
        var name: String = ""
            private set
        var surname: String = ""
            private set

        fun name(name: String) = apply { this.name = name }
        fun surname(surname: String) = apply { this.surname = surname }
        fun build() = GoogleAuthor(this)
    }
}