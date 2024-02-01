package com.realworld.model

import com.realworld.enums.SocialPlatform
import jakarta.persistence.*


@Entity(name = "SocialMedia")
@Table(name = "socialmedia", schema = "good_books")
data class SocialMedia(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "url")
    val url: String?,
    @Enumerated(value = EnumType.STRING)
    var platform: SocialPlatform?,
    @ManyToOne
    @JoinColumn(name = "account_id")
    var account: Account?
) {
    protected constructor() : this(Builder())

    private constructor(builder: Builder) : this(
        null,
        builder.url,
        builder.socialMedia,
        builder.account
    )

    class Builder {
        var id: Long? = null
            private set
        var url: String? = ""
            private set
        var socialMedia: SocialPlatform? = null
            private set
        var account: Account? = null
            private set

        fun id(id: Long) = apply { this.id = id }
        fun url(url: String) = apply { this.url = url }
        fun socialMedia(socialMedia: SocialPlatform) = apply { this.socialMedia = socialMedia }
        fun account(account: Account?)  = apply { this.account = account }
        fun build() = SocialMedia(this)
    }
}
