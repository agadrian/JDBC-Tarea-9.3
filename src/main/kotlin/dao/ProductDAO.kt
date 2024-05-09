package org.example.dao

import org.example.entity.Product
import org.example.output.IConsole
import java.sql.SQLException
import javax.sql.DataSource

class ProductDAO(
    private val dataSource: DataSource,
    private val console: IConsole
): IProductDAO {
    override fun createProduct(product: Product): Product? {
        val sql = "INSERT INTO products (id, name, price, description, brand, category) VALUES (?, ?, ?, ?, ?, ?)"

        return try{
            dataSource.connection.use {
                connection ->
                connection.prepareStatement(sql).use {stmt ->
                    stmt.setInt(1, product.id)
                    stmt.setString(2, product.name)
                    stmt.setFloat(3, product.price)
                    stmt.setString(4, product.description)
                    stmt.setString(5, product.brand)
                    stmt.setString(6, product.category)

                    // Almacenar el num de filas afectadas
                    val rs = stmt.executeUpdate()

                    // Comprobar si se ha creado la fila o no
                    if (rs == 1){
                        product
                    }else{
                        console.showMessage("ERROR - Insert query failed ($rs rows affected) ")
                        null
                    }

                }
            }
        }catch (e: SQLException){
            console.showMessage("ERROR - Insert query failed (${e.message})")
            null
        }
    }

}
