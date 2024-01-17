package com.realworld.model

import com.realworld.enums.Role
import jakarta.persistence.*
import org.springframework.boot.autoconfigure.security.SecurityProperties.User

@Entity(name = "Account")
@Table(name = "account", schema = "good_books")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(unique = true)
    val username: String?,
    @Column(unique = true)
    val email: String?,
    var password: String?,
    @Enumerated
    var role: Role?,
    @OneToOne(mappedBy = "userfollow")
    var following: Set<UserFollow>?,
    @OneToOne
    var followers: Set<UserFollow>?,
    @ManyToMany
    var favorites: Set<Book>?,
    var accountExpired: Boolean?,
    var accountLock: Boolean?,
    var credentialSlock: Boolean?,
    var enabled: Boolean?
) {
    protected constructor() : this(Builder())

    private constructor(builder: Builder) : this(
        null,
        builder.username,
        builder.email,
        builder.password,
        builder.role,
        builder.following,
        builder.followers,
        builder.favorites,
        builder.accountExpired,
        builder.accountLock,
        builder.credentialSlock,
        builder.enabled
    )

    class Builder {
        var username: String? = ""
            private set
        var email: String? = ""
            private set
        var password: String? = ""
            private set
        var role: Role? = null
            private set
        var following: Set<UserFollow>? = null
            private set
        var followers: Set<UserFollow>? = null
            private set
        var favorites: Set<Book>? = null
            private set
        var accountExpired: Boolean? = null
            private set
        var accountLock: Boolean? = null
            private set
        var credentialSlock: Boolean? = null
            private set
        var enabled: Boolean? = null
            private set

        fun username(username: String) = apply { this.username = username }
        fun email(email: String) = apply { this.email = email }
        fun role(role: Role) = apply { this.role = role }
        fun following(following: Set<UserFollow>) = apply { this.following = following }
        fun followers(followers: Set<UserFollow>) = apply { this.followers = followers }
        fun favorites(favorites: Set<Book>) = apply { this.favorites = favorites }
        fun accountExpired(accountExpired: Boolean) = apply { this.accountExpired = accountExpired }
        fun accountLock(accountLock: Boolean) = apply { this.accountLock = accountLock }
        fun credentialSlock(credentialSlock: Boolean) = apply { this.credentialSlock = credentialSlock }
        fun enabled(enabled: Boolean) = apply { this.enabled = enabled }
        fun build() = Account(this)
    }
}