package com.realworld.model

import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity(name = "SocialMedia")
@Table(name = "socialmedia", schema = "good_books")
data class SocialMedia(
    val name:String?,
    var socialMedia: String?
){
    protected constructor() : this(Builder())

    private constructor(builder: Builder) : this(
        builder.name,
        builder.socialMedia
    )

    class Builder {
        var name: String? = ""
            private set
        var socialMedia: String? = ""
            private set

        fun name(name: String) = apply { this.name = name }
        fun socialMedia(socialMedia: String) = apply { this.socialMedia = socialMedia }
    }



}
