package com.realworld.model

import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity(name = "Person")
@Table(name = "person")
data class Person(
    var name: String?,
    var surname: String?,
    var biography: String?,
    var profilePhoto: String?,
    @OneToMany
    var personSocialMedia: Set<SocialMedia>?

) {
    protected constructor() : this(Builder())

    private constructor(builder: Builder) : this(
        builder.name,
        builder.surname,
        builder.biography,
        builder.profilePhoto,
        builder.personSocialMedia
    )

    class Builder {
        var name: String? = ""
            private set
        var surname: String? = ""
            private set
        var biography: String? = ""
            private set
        var profilePhoto: String? = ""
            private set
        var personSocialMedia: Set<SocialMedia>? = null
            private set
    }

    fun name(name: String) = apply { this.name = name }
    fun surname(surname: String) = apply { this.surname = surname }
    fun biography(biography: String) = apply { this.biography = biography }
    fun profilePhoto(profilePhoto: String) = apply { this.profilePhoto = profilePhoto }
    fun personSocialMedia(personSocialMedia: Set<SocialMedia>) = apply { this.personSocialMedia = personSocialMedia }
}
