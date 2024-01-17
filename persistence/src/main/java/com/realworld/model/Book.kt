package com.realworld.model

import jakarta.persistence.*

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
    @ManyToMany
    @JoinTable(
        name = "book_authors", schema = "good_books",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    var authors: Set<Author>?,
    @ManyToMany
    @JoinTable(
        name = "book_categories", schema = "good_books",
        joinColumns =  [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    var categories: Set<BookCategories>?,
    @OneToOne(mappedBy = "book")
    var imageLink: BookImageLink?,
    @OneToOne(mappedBy = "book")
    var saleInfo: BookSaleInfo?,
    var pdfLink: String?,
    @ManyToMany(mappedBy = "favorites")
    var favoritedByAccounts: Set<Account>?
) {
    protected constructor() : this(Builder())
    private constructor(builder: Builder) : this(
        builder.id,
        builder.title,
        builder.description,
        builder.publisher,
        builder.pageCount,
        builder.authors,
        builder.categories,
        builder.imageLink,
        builder.saleInfo,
        builder.pdfLink,
        builder.favoritedByAccounts
    )

    class Builder {
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
        var authors: Set<Author>? = null
            private set
        var categories: Set<BookCategories>? = null
            private set
        var imageLink: BookImageLink? = null
            private set
        var saleInfo: BookSaleInfo? = null
            private set
        var pdfLink: String? = ""
            private set
        var favoritedByAccounts: Set<Account>? = null
            private set

        fun id(id: String) = apply { this.id = id }
        fun title(title: String?) = apply { this.title = title }
        fun description(description: String?) = apply { this.description = description }
        fun publisher(publisher: String?) = apply { this.publisher = publisher }
        fun pageCount(pageCount: Short?) = apply { this.pageCount = pageCount }
        fun authors(authors: Set<Author>?) = apply { this.authors = authors }
        fun categories(categories: Set<BookCategories>?) = apply { this.categories = categories }
        fun imageLink(imageLink: BookImageLink?) = apply { this.imageLink = imageLink }
        fun saleInfo(saleInfo: BookSaleInfo?) = apply { this.saleInfo = saleInfo }
        fun pdfLink(pdfLink: String?) = apply { this.saleInfo = saleInfo }
        fun favoritedByAccounts(favoritedByAccounts: Set<Account>?) = apply { this.favoritedByAccounts = favoritedByAccounts }
        fun build() = Book(this)

    }
}
