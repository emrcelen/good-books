package com.realworld.model

data class GoogleBook(
    val bookId: String,
    val title: String,
    val description: String?,
    val publisher: String?,
    val pageCount: Int?,
    val authors: List<GoogleAuthor>?,
    val imageLinks: GoogleBookImage?,
    val saleInfo: GoogleSaleInfo?,
    val pdfLink: String?
) {
    private constructor(builder: Builder) : this(
        builder.bookId,
        builder.title,
        builder.description,
        builder.publisher,
        builder.pageCount,
        builder.authors,
        builder.imageLinks,
        builder.saleInfo,
        builder.pdfLink
    )

    class Builder {
        var bookId: String = ""
            private set
        var title: String = ""
            private set
        var description: String? = ""
            private set
        var publisher: String? = ""
            private set
        var pageCount: Int? = 0
            private set
        var authors: List<GoogleAuthor>? = null
            private set
        var imageLinks: GoogleBookImage? = null
            private set
        var saleInfo: GoogleSaleInfo? = null
            private set
        var pdfLink: String? = null
            private set

        fun bookId(bookId: String) = apply { this.bookId = bookId }
        fun title(title: String) = apply { this.title = title }
        fun description(description: String?) = apply { this.description = description }
        fun publisher (publisher: String?) = apply { this.publisher = publisher }
        fun pageCount(pageCount: Int?) = apply { this.pageCount = pageCount }
        fun authors(authors: List<GoogleAuthor> ?) = apply { this.authors = authors }
        fun imageLinks(imageLinks: GoogleBookImage?) = apply { this.imageLinks = imageLinks }
        fun saleInfo(saleInfo: GoogleSaleInfo?) = apply { this.saleInfo = saleInfo }
        fun pdfLink(pdfLink: String?) = apply { this.pdfLink = pdfLink }
        fun build() = GoogleBook(this)
    }
}