package com.max.leroymerlinchebmax

import java.math.BigDecimal

class PuttyRepository {
    fun getAllData():List<Putty>{
        return listOf(
            Putty(
                articleId = 0,
                image = R.drawable.danogips,
                title = "Шпаклёвка готовая финишная Danogips SuperFinish 18.1 кг",
                price = "1155 ₽/шт.",

            ),
            Putty(
                articleId = 1,
                image = R.drawable.knauf,
                title = "Шпаклёвка виниловая суперфинишная Knauf Ротбанд Паста 18 кг",
                price = "1155 ₽/шт.",

            ),
            Putty(
                articleId = 2,
                image = R.drawable.axton,
                title = "Шпаклёвка полимерная суперфинишная Axton 25 кг",
                price = "1155 ₽/шт.",

            ),
        )
    }
}