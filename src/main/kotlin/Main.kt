package org.example

import org.example.dao.ProductDAO
import org.example.db_connection.DataSourceFactory
import org.example.db_connection.Database
import org.example.entity.Product
import org.example.output.Console

fun main() {
    //Crear consola
    val console = Console()

    // Creamos la instancia de la base de datos
    val dataSource = Database.getConnection()

    // Creamos la instancia de UserDAO
    val userDao = ProductDAO(dataSource, console)



    val product = Product(1, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")

    val product2 = Product(3, "aaa", 1999.99f, "The latest computer for gaming", "Asus", "Electronics")

    val productId = userDao.createProduct(product2)

    println("Product ID: $productId")

}