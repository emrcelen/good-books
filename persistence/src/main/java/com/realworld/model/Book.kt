package com.realworld.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity(name = "Book")
@Table(name = "book", schema = "good_books")
data class Book(
    @Id
    @Column(name = "book_id")
    val id: String,
    var title: String?,
    @Column(length = 500)
    var description: String?,
    var publisher: String?,
    var pageCount: Short?,
    @OneToOne(mappedBy = "book")
    var imageLink: BookImageLink?,
    @OneToOne(mappedBy = "book")
    var saleInfo: BookSaleInfo?,
    var pdfLink: String?
){
    protected constructor() : this(Builder())
    private constructor(builder: Builder) : this(
        builder.id,
        builder.title,
        builder.description,
        builder.publisher,
        builder.pageCount,
        builder.imageLink,
        builder.saleInfo,
        builder.pdfLink
    )
    class Builder{
        var id: String = ""
            private set
        var title: String? = ""
            private set
        var description: String? = ""
            private set
        var publisher: String? = ""
            private set
        var pageCount: Short? = 0
            private set
        var imageLink: BookImageLink? = null
            private set
        var saleInfo: BookSaleInfo? = null
            private set
        var pdfLink: String? = ""
            private set

        fun id(id: String) = apply { this.id = id }
        fun title(title: String?) = apply { this.title = title }
        fun description(description: String?) = apply { this.description = description }
        fun publisher(publisher: String?) = apply { this.publisher = publisher }
        fun pageCount(pageCount: Short?) = apply { this.pageCount = pageCount }
        fun imageLink(imageLink: BookImageLink?) = apply { this.imageLink = imageLink }
        fun saleInfo(saleInfo: BookSaleInfo?) = apply { this.saleInfo = saleInfo }
        fun pdfLink(pdfLink: String?) = apply { this.saleInfo = saleInfo }
        fun build() = Book(this)

    }
}
