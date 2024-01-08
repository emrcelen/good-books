package com.realworld.model

data class GoogleSaleInfo(
    val country: String,
    val salebility: String,
    val isEbook: Boolean,
    val listPrice: GoogleSalePrice?,
    val retailPrice: GoogleSalePrice?,
    val buyLink: String?
) {
    private constructor(builder: Builder) : this(
        builder.country,
        builder.salebility,
        builder.isEbook,
        builder.listPrice,
        builder.retailPrice,
        builder.buyLink
    )

    class Builder {
        var country: String = ""
            private set
        var salebility: String = ""
            private set
        var isEbook: Boolean = false
            private set
        var listPrice: GoogleSalePrice? = null
            private set
        var retailPrice: GoogleSalePrice? = null
            private set
        var buyLink: String? = null
            private set

        fun country(country: String) = apply { this.country = country }
        fun salebility(salebility: String) = apply { this.salebility = salebility }
        fun isEbook(isEbook: Boolean) = apply { this.isEbook = isEbook }
        fun listPrice(listPrice: GoogleSalePrice?) = apply { this.listPrice = listPrice }
        fun retailPrice(retailPrice: GoogleSalePrice?) = apply { this.retailPrice = retailPrice }
        fun buyLink(buyLink: String?) = apply { this.buyLink = buyLink }
        fun build() = GoogleSaleInfo(this)
    }
}