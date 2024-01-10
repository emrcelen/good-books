package com.realworld.model

import com.realworld.enums.Role
import jakarta.persistence.*

@Entity(name = "Account")
@Table(name = "account")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    @Column(unique = true)
    val username: String,
    @Column(unique = true)
    val email: String,
    var password: String,
    var role: Role,
    var following:Set<UserFollow>?,
    var followers: Set<UserFollow>?,
    var favorites: Set<Book>?,
    var accountExpired: Boolean?,
    var accountLock: Boolean?,
    var credentialSlock: Boolean?,
    var enabled: Boolean?
)
