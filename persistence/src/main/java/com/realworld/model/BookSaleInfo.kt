package com.realworld.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

@Entity(name = "BookSaleInfo")
@Table(name = "book_sale_info", schema = "good_books")
data class BookSaleInfo(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "book_sale_info_id")
    val id: UUID?,
    var country: String?,
    var salebility: String?,
    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "amount", column = Column(name = "list_price_amount")),
        AttributeOverride(name = "currencyCode", column = Column(name = "list_price_currency"))
    )
    var listPrice: SalePrice?,
    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "amount", column = Column(name = "retail_price_amount")),
        AttributeOverride(name = "currencyCode", column = Column(name = "retail_price_currency"))
    )
    var retailPrice: SalePrice?,
    var buyLink: String?,
    var ebook: Boolean?,
    @OneToOne
    @JoinColumn(name = "book_id")
    var book: Book?
) {
    protected constructor() : this(Builder())
    private constructor(builder: Builder) : this(
        null,
        builder.country,
        builder.salebility,
        builder.listPrice,
        builder.retailPrice,
        builder.buyLink,
        builder.ebook,
        builder.book
    )
    class Builder {
        var country: String? = ""
            private set
        var salebility: String? = ""
            private set
        var listPrice: SalePrice? = null
            private set
        var retailPrice: SalePrice? = null
            private set
        var buyLink: String? = ""
            private set
        var ebook: Boolean? = false
            private set
        var book: Book? = null
            private set

        fun country(country: String?) = apply { this.country = country }
        fun salebility(salebility: String?) = apply { this.salebility = salebility }
        fun listPrice(listPrice: SalePrice?) = apply { this.listPrice = listPrice }
        fun retailPrice(retailPrice: SalePrice?) = apply { this.retailPrice = retailPrice }
        fun buyLink(buyLink: String?) = apply { this.buyLink = buyLink }
        fun ebook(ebook: Boolean?) = apply { this.ebook = ebook }
        fun book(book: Book?) = apply { this.book = book }
        fun build() = BookSaleInfo(this)
    }
}
