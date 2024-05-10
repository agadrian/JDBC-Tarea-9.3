package org.example.output

import org.example.entity.Product


interface IConsole {
    fun showMessage(message: String, lineBreak: Boolean = true)
    fun show(productList: List<Product>?, message: String = "All prodcuts")
}