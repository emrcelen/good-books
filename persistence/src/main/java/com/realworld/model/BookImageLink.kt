package com.realworld.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

@Entity(name = "BookImageLink")
@Table(name = "book_image_links", schema = "good_books")
data class BookImageLink(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "book_image_links_id")
    val id: UUID?,
    var thumbnail: String?,
    var smallThumbnail: String?,
    var small: String?,
    var medium: String?,
    var large: String?,
    var extraLarge: String?,
    @OneToOne
    @JoinColumn(name = "book_id")
    var book: Book?
) {
    protected constructor() : this(Builder())
    private constructor(builder:Builder) : this(
        null,
        builder.thumbnail,
        builder.smallThumbnail,
        builder.small,
        builder.medium,
        builder.large,
        builder.extraLarge,
        builder.book
    )
    class Builder {
        var thumbnail: String? = ""
            private set
        var smallThumbnail: String? = ""
            private set
        var small: String? = ""
            private set
        var medium: String? = ""
            private set
        var large: String? = ""
            private set
        var extraLarge: String? = ""
            private set
        var book: Book? = null
            private set

        fun thumbnail(thumbnail: String?) = apply { this.thumbnail = thumbnail }
        fun smallThumbnail (smallThumbnail: String?) = apply { this.smallThumbnail = smallThumbnail }
        fun small(small: String?) = apply { this.small = small }
        fun medium(medium: String?) = apply { this.medium = medium }
        fun large(large: String?) = apply { this.large = large }
        fun extraLarge(extraLarge: String?) = apply { this.extraLarge = extraLarge }
        fun book(book: Book?) = apply { this.book = book }
        fun build() = BookImageLink(this)
    }
}
