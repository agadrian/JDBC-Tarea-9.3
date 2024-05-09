package org.example.dao

import org.example.entity.Product

interface IProductDAO {
    fun createProduct(product: Product): Product?
}