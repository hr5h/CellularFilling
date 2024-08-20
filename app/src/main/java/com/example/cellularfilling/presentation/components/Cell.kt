package com.example.cellularfilling.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cellularfilling.data.CellModel
import com.example.cellularfilling.data.CellType

@Composable
fun Cell(model: CellModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 1.dp, bottom = 2.dp, start = 20.dp, end = 20.dp)
            .clip(RoundedCornerShape(8.dp)),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        ) {
            Image(
                painterResource(
                    id = model.image
                ),
                contentDescription = "img",
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .size(40.dp)
            )
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = model.typeString, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = model.description, fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCell() {
    Cell(CellModel(CellType.ALIVE))
}