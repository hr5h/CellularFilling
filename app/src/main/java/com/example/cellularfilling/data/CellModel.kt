package com.example.cellularfilling.data

import com.example.cellularfilling.R

data class CellModel(
    val type: CellType = CellType.DEFAULT,
    val image: Int = R.drawable.ic_launcher_foreground,
    val typeString: String = "Неизвестная",
    val description: String = "неизвестная клетка",
    val uid: Int = 0
)

enum class CellType {
    ALIVE, DEAD, LIFE, DEFAULT
}