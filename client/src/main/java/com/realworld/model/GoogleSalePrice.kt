package com.realworld.model

data class GoogleSalePrice(
    val amount: Double,
    val currencyCode: String
) {
    private constructor(builder: Builder) : this(builder.amount, builder.currencyCode)

    class Builder {
        var amount: Double = 0.0
            private set
        var currencyCode: String = ""
            private set

        fun amount(amount: Double) = apply { this.amount = amount }
        fun currencyCode(currencyCode: String) = apply { this.currencyCode = currencyCode }
        fun build() = GoogleSalePrice(this)
    }
}