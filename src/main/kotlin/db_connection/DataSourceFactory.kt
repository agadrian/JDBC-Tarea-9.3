package org.example.db_connection

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.apache.commons.dbcp2.BasicDataSource
import javax.sql.DataSource



object DataSourceFactory {
    enum class DataSourceType {
        HIKARI,
        JDBC
    }

    fun getDS(dataSourceType: DataSourceType): DataSource {
        return when (dataSourceType) {
            DataSourceType.HIKARI -> {
                val config = HikariConfig()
                config.jdbcUrl = "jdbc:h2:./default"
                config.username = "user"
                config.password = "user"
                config.driverClassName = "org.h2.Driver"
                config.maximumPoolSize = 10
                config.isAutoCommit = true
                config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
                HikariDataSource(config)
            }

            DataSourceType.JDBC -> {
                val dataSource = BasicDataSource()
                dataSource.url = "jdbc:h2:./default"
                dataSource.username = "user"
                dataSource.password = "user"
                dataSource.driverClassName = "org.h2.Driver"
                dataSource.maxTotal = 10 // máximo número de conexiones en el pool
                dataSource.defaultAutoCommit = true
                dataSource.defaultTransactionIsolation = java.sql.Connection.TRANSACTION_REPEATABLE_READ
                dataSource
            }
        }
    }
}
