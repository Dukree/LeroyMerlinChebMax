package com.max.leroymerlinchebmax.cart.models

import com.max.leroymerlinchebmax.catalog.models.Putty


class CartItem(list: List<Putty> = listOf()) {
    var putty: List<Putty>
        private set

    init {
        putty = list
    }

    var totalPrice: Int = putty.sumOf { it.price }
    var count: Int = putty.size

    fun getByPostition(position: Int): Putty {
        return putty[position]
    }
}

fun CartItem?.add(putty: Putty): CartItem {
    return if (this==null) CartItem()
    else CartItem(list = this.putty + putty)
}

fun CartItem?.remove(putty: Putty) : CartItem {
    return if (this==null) CartItem()
    else CartItem(list = this.putty.filter { it.articleId != putty.articleId  })
}



