package com.example.cellularfilling

import androidx.lifecycle.ViewModel
import com.example.cellularfilling.data.CellModel
import com.example.cellularfilling.data.CellType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    val state = MutableStateFlow(MainState())

    fun addCell() {
        val rand = (0..1).random()
        var type = CellType.DEFAULT
        var image = R.drawable.ic_launcher_foreground
        var typeString = "Неизвестная"
        var description = "неизвестная клетка"
        when (rand) {
            0 -> {
                type = CellType.ALIVE
                image = R.drawable.cell_alive
                typeString = "Живая"
                description = "и шевелится!"
                if (state.value.listCell.isNotEmpty() && state.value.listCell.last().type == CellType.ALIVE)
                    state.update { it.copy(count = it.count + 1) }
                else
                    state.update { it.copy(count = 1) }
            }

            1 -> {
                type = CellType.DEAD
                image = R.drawable.cell_dead
                typeString = "Мёртвая"
                description = "или прикидывается"
                if (state.value.listCell.isNotEmpty() && state.value.listCell.last().type == CellType.DEAD)
                    state.update { it.copy(count = it.count + 1) }
                else
                    state.update { it.copy(count = 1) }
            }
        }

        state.update {
            it.copy(
                listCell = it.listCell + CellModel(
                    type = type,
                    image = image,
                    typeString = typeString,
                    description = description,
                    uid = it.listCell.count()
                )
            )
        }

        if (state.value.count == 3) {
            if (state.value.listCell.last().type == CellType.ALIVE) {
                state.update {
                    it.copy(
                        count = 0,
                        listCell = it.listCell + CellModel(
                            type = CellType.LIFE,
                            image = R.drawable.life,
                            typeString = "Жизнь",
                            description = "Ку-ку!",
                            uid = it.listCell.count()
                        ),
                        listLife = it.listLife + it.listCell.count()
                    )
                }
            } else if (state.value.listCell.last().type == CellType.DEAD) {
                val index = state.value.listLife.lastOrNull()
                if(index != null) {
                    state.update {
                        it.copy(
                            count = 0,
                            listCell = it.listCell - it.listCell[index],
                            listLife = it.listLife - it.listLife[(it.listLife.count() - 1)]
                        )
                    }
                }
            }
        }
    }
}