package com.example.cellularfilling.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cellularfilling.MainState
import com.example.cellularfilling.R
import com.example.cellularfilling.data.CellModel
import com.example.cellularfilling.presentation.components.Cell
import com.example.cellularfilling.ui.theme.Purple
import com.example.cellularfilling.ui.theme.Purple2

@Composable
fun MainScreen(
    state: MainState,
    addCell: () -> Unit
) {
    val gradient = Brush.verticalGradient(
        0.0f to Purple2,
        1.0f to Color.Black,
        startY = 0.0f,
        endY = 1500.0f
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp, bottom = 25.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Клеточное наполнение",
                modifier = Modifier,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        val chatListState = rememberLazyListState()
        LaunchedEffect(state.listCell){
            chatListState.animateScrollToItem(chatListState.layoutInfo.totalItemsCount)
        }
        LazyColumn(
            modifier = Modifier.fillMaxHeight(0.93f),
            state = chatListState
        ) {
            itemsIndexed(state.listCell) { _, item ->
                Cell(model = item)
            }
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Purple),
            onClick = {
                addCell()
            }) {
            Text(
                text = "СОТВОРИТЬ",
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen(
        MainState(
            listCell = mutableListOf(
                CellModel(
                    image = R.drawable.cell_alive,
                    typeString = "Живая",
                    description = "и шевелится!"
                ),
                CellModel(
                    image = R.drawable.cell_dead,
                    typeString = "Мёртвая",
                    description = "или прикидывается"
                ),
                CellModel(
                    image = R.drawable.life,
                    typeString = "Жизнь",
                    description = "Ку-ку!"
                )
            )
        ), {}
    )
}