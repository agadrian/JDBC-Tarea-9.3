package org.example.db_connection

import java.lang.RuntimeException
import java.sql.*
import javax.sql.DataSource


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
