package org.example.dao

import org.example.db_connection.Database
import org.example.entity.Product
import org.example.output.IConsole
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException
import javax.sql.DataSource

class ProductDAO(
    private val console: IConsole
): IProductDAO {


    override fun createProduct(product: Product): Product? {
        var connection: Connection? = null


        try{
            connection = Database.getConnection()
            val query = "INSERT INTO products (id, name, price, description, brand, category) VALUES (?, ?, ?, ?, ?, ?)"

            val stmt = connection?.prepareStatement(query)

            if (stmt != null) {
                stmt.setInt(1, product.id)
                stmt.setString(2, product.name)
                stmt.setFloat(3, product.price)
                stmt.setString(4, product.description)
                stmt.setString(5, product.brand)
                stmt.setString(6, product.category)

            }else {
                throw SQLException("Error al insertar en la base de datos")
            } catch (e: SQLException){
            throw SQLException("Error al insertar en la base de datos: ${e.message}")
        }
    }

}
