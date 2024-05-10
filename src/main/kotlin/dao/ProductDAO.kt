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

        return try{
            connection = Database.getConnection() ?: throw SQLException("No se pudo establecer conexion con la BBDD ")

            val query = "INSERT INTO products (id, name, price, description, brand, category) VALUES (?, ?, ?, ?, ?, ?)"

            connection.prepareStatement(query).use { stmt ->
                stmt.setInt(1, product.id)
                stmt.setString(2, product.name)
                stmt.setFloat(3, product.price)
                stmt.setString(4, product.description)
                stmt.setString(5, product.brand)
                stmt.setString(6, product.category)

                val rs = stmt.executeUpdate()

                if (rs == 1) {
                    product
                } else{
                    console.showMessage("ERROR - Insert query failed ($rs rows affected) ")
                    null
                }

            }



        }catch (e: SQLException) {
            //throw SQLException("Error al insertar en la base de datos: ${e.message}")
            console.showMessage("**Error: $e")
            null
        }catch (e: RuntimeException){
            console.showMessage("**ERROR - $e")
            null
        }finally {
            connection?.close()
        }
    }

}
