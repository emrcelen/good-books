package com.realworld.model

import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity(name = "Person")
@Table(name = "person")
data class Person(
    val name: String?,
    val surname: String?,
    val biography: String?,
    val profilePhoto: String?,
    @OneToMany
    val personSocialMedia: Set<SocialMedia>
)
