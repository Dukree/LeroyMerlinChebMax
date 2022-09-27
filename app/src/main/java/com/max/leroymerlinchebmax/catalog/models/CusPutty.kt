package com.max.leroymerlinchebmax.catalog.models

class CusPutty (list: List<Putty> = listOf()) {
    private var putty: List<Putty> = list

    var count : Int = putty.size

    fun getByPosition(position : Int): Putty {
        return putty[position]
    }
}
