package org.example.db_connection

import java.lang.RuntimeException
import java.sql.*
import javax.sql.DataSource

/*

config.jdbcUrl = "jdbc:h2:./default"
config.username = "user"
config.password = "user"
config.driverClassName = "org.h2.Driver"
 */


object Database {

    private const val DB_URL = "jdbc:h2:./default"
    private const val USER = "user"
    private const val PASS = "user"

    fun getConnection(): Connection? {
        val conn: Connection?
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS)
        } catch (e: SQLException) {
            throw RuntimeException("Error al conectar con la base de datos: ${e.message}")
        }
        return conn
    }
}
