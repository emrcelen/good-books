package com.realworld.model

import com.realworld.enums.Role
import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity(name = "Account")
@Table(name = "account")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(unique = true)
    val username: String,
    @Column(unique = true)
    val email: String,
    var password: String,
    var role: Role,

    @OneToMany
//    @OnDelete(action = OnDeleteAction.CASCADE)
    var following:Set<UserFollow>?,

    @OneToMany
    var followers: Set<UserFollow>?,

//    Buraya takip ettikleri person'lar için field eklenmeli mi (Set<Person>) gibi?

    @ManyToMany
    var favorites: Set<Book>?,

    var accountExpired: Boolean?,
    var accountLock: Boolean?,
    var credentialSlock: Boolean?,
    var enabled: Boolean?
)
