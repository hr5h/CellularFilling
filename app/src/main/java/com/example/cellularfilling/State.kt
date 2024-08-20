package com.example.cellularfilling

import com.example.cellularfilling.data.CellModel

data class MainState(
    val listCell: List<CellModel> = emptyList(),
    val count: Int = 0,
    val listLife: List<Int> = emptyList()
)
