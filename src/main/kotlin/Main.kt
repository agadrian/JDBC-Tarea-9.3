package org.example

import org.example.dao.ProductDAO
import org.example.entity.Product
import org.example.output.Console

fun main() {
    //Crear consola
    val console = Console()

    val product = Product(1, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")

    val productId = ProductDAO(console).createProduct(product)

    if (productId != null) console.showMessage("Product ID: $productId")



}