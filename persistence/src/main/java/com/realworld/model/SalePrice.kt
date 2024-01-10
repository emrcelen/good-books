package com.realworld.model

import jakarta.persistence.Embeddable

@Embeddable
data class SalePrice(
    var amount: Double?,
    var currencyCode: String?,
){
    protected constructor() : this(Builder())
    private constructor(builder:Builder) : this(
        builder.amount,
        builder.currencyCode
    )
    class Builder{
        var amount: Double? = 0.0
            private set
        var currencyCode: String? = ""
            private set

        fun amount(amount: Double?) = apply { this.amount = amount }
        fun currencyCode(currencyCode: String?) = apply { this.currencyCode = currencyCode }
        fun build() = SalePrice(this)
    }
}
