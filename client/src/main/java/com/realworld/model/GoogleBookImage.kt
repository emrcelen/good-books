package com.realworld.model

data class GoogleBookImage(
    val smallThumbnail: String?,
    val thumbnail: String?
) {
    private constructor(builder: Builder) : this(builder.smallThumbnail, builder.thumbnail)

    class Builder {
        var smallThumbnail: String? = ""
            private set
        var thumbnail: String? = ""
            private set

        fun smallThumbnail(smallThumbnail: String?) = apply { this.smallThumbnail = smallThumbnail }
        fun thumbnail(thumbnail: String?) = apply { this.thumbnail = thumbnail }
        fun build() = GoogleBookImage(this)
    }
}