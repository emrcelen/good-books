package com.realworld.model

import com.realworld.enums.Role
import jakarta.persistence.*

@Entity(name = "Account")
@Table(name = "account", schema = "good_books")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    val id: Long?,
    @Column(unique = true)
    val username: String?,
    @Column(unique = true)
    val email: String?,
    var password: String?,
    @Enumerated
    var role: Role?,
    @ManyToMany(mappedBy = "followers")
    var following: Set<Account>?,
    @ManyToMany
    @JoinTable(
        name = "account_followers", schema = "good_books",
        joinColumns = [JoinColumn(name = "account_id")],
        inverseJoinColumns = [JoinColumn(name = "follower_id")]
    )
    var followers: Set<Account>?,
    @ManyToMany
    @JoinTable(
        name = "account_favorite_books", schema = "good_books",
        joinColumns = [JoinColumn(name = "account_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")]
    )
    var favorites: Set<Book>?,
    @OneToMany(mappedBy = "account")
    var socialMedia: Set<SocialMedia>?,
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
        builder.socialMedia,
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
        var following: Set<Account>? = null
            private set
        var followers: Set<Account>? = null
            private set
        var favorites: Set<Book>? = null
            private set
        var socialMedia: Set<SocialMedia>? = null
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
        fun following(following: Set<Account>) = apply { this.following = following }
        fun followers(followers: Set<Account>) = apply { this.followers = followers }
        fun favorites(favorites: Set<Book>) = apply { this.favorites = favorites }
        fun socialMedia(socialMedia: Set<SocialMedia>) = apply { this.socialMedia = socialMedia }
        fun accountExpired(accountExpired: Boolean) = apply { this.accountExpired = accountExpired }
        fun accountLock(accountLock: Boolean) = apply { this.accountLock = accountLock }
        fun credentialSlock(credentialSlock: Boolean) = apply { this.credentialSlock = credentialSlock }
        fun enabled(enabled: Boolean) = apply { this.enabled = enabled }
        fun build() = Account(this)
    }
}