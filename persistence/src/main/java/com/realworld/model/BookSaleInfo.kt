package com.realworld.model

import jakarta.annotation.Nullable
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.springframework.boot.context.properties.bind.DefaultValue

@Entity(name = "BookSaleInfo")
@Table(name = "booksaleinfo")
data class BookSaleInfo(
    val country:String, // Sadece TR?
    @Nullable()
    val saleability: Boolean?,
    val listPrice: Int?,
    val retailPrice: Int?,
    val buyLink: String?,
    val ebook: String?
)
