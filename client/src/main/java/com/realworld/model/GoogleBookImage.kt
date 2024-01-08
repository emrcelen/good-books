package com.realworld.model

data class GoogleBookImage(
    val smallThumbnail: String?,
    val thumbnail: String?,
    val small: String?,
    val medium: String?,
    val large: String?,
    val extraLarge: String?
) {
    private constructor(builder: Builder) : this(
        builder.smallThumbnail,
        builder.thumbnail,
        builder.small,
        builder.medium,
        builder.large,
        builder.extraLarge
    )

    class Builder {
        var smallThumbnail: String? = ""
            private set
        var thumbnail: String? = ""
            private set
        var small: String? = ""
            private set
        var medium: String? = ""
            private set
        var large: String? = ""
            private set
        var extraLarge: String? = ""
            private set

        fun smallThumbnail(smallThumbnail: String?) = apply { this.smallThumbnail = smallThumbnail }
        fun thumbnail(thumbnail: String?) = apply { this.thumbnail = thumbnail }
        fun small(small: String?) = apply { this.small = small }
        fun medium(medium: String?) = apply { this.medium = medium }
        fun large(large: String?) = apply { this.large = large }
        fun extraLarge(extraLarge: String?) = apply { this.extraLarge = extraLarge }
        fun build() = GoogleBookImage(this)
    }
}