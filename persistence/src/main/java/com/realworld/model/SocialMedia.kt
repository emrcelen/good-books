package com.realworld.model

import jakarta.persistence.*


@Entity(name = "SocialMedia")
@Table(name = "socialmedia", schema = "good_books")
data class SocialMedia(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String?,
    var socialMedia: String?
) {
    protected constructor() : this(Builder())

    private constructor(builder: Builder) : this(
        null,
        builder.name,
        builder.socialMedia
    )

    class Builder {
        var id: Long? = null
            private set
        var name: String? = ""
            private set
        var socialMedia: String? = ""
            private set

        fun id(id: Long) = apply { this.id = id }

        fun name(name: String) = apply { this.name = name }
        fun socialMedia(socialMedia: String) = apply { this.socialMedia = socialMedia }
        fun build() = SocialMedia(this)
    }
}
