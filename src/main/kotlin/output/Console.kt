package org.example.output

import org.example.entity.Product

class Console: IConsole {

    override fun showMessage(message: String, lineBreak: Boolean){
        if (lineBreak) println(message) else print(message)
    }

    override fun show(userList: List<Product>?, message: String){
        if (userList != null){
            if (userList.isNotEmpty()){
                showMessage(message)
                userList.forEachIndexed { index, user ->
                    showMessage("${index + 1}. $user ")
                }
            }else{
                showMessage("No prodcut found!")
            }
        }

    }
}