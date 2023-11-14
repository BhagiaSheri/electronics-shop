package com.miu.electronics_shop

import java.io.Serializable

data class Product(
    val productName: String,
    val productDescription: String,
    val productImage: Int,
    val productLogo: Int,
    val cost: Double
) : Serializable
