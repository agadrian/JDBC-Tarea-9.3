package org.example.output

import org.example.entity.Product

class Console: IConsole {

    override fun showMessage(message: String, lineBreak: Boolean){
        if (lineBreak) println(message) else print(message)
    }

    // No se usa
    override fun show(productList: List<Product>?, message: String){
        if (productList != null){
            if (productList.isNotEmpty()){
                showMessage(message)
                productList.forEachIndexed { index, product ->
                    showMessage("${index + 1}. $product ")
                }
            }else{
                showMessage("No prodcut found!")
            }
        }
    }
}