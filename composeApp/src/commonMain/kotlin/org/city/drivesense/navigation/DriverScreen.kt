package org.city.drivesense.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import drivesense.composeapp.generated.resources.Res
import drivesense.composeapp.generated.resources.average
import drivesense.composeapp.generated.resources.reviews_driver
import drivesense.composeapp.generated.resources.reviews_list
import drivesense.composeapp.generated.resources.reviews_write
import drivesense.composeapp.generated.resources.statistics
import drivesense.composeapp.generated.resources.trips
import org.city.drivesense.db.ReviewData
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun DriverScreen(
    driverScreenComponent: DriverScreenComponent,
    modifier: Modifier = Modifier.fillMaxWidth()
                 ){
    Column(modifier = modifier) {
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .padding(3.dp)
        ) {
            item {
                Spacer(
                    Modifier.height(17.dp)
                )
                Card(
                    elevation = CardDefaults.elevatedCardElevation(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Row {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "avatar_driver",
                            Modifier
                                .size(60.dp)
                                .padding(3.dp)
                                .clip(CircleShape)
                        )
                        Column {
                            Row {
                                Text(
                                    "Равшан\n" +
                                            "Кулисбегович",
                                    fontSize = 20.sp
                                )
                                Box(
                                    modifier = Modifier.weight(1f),
                                    contentAlignment = Alignment.CenterEnd
                                ) {
                                    Icon(
                                        Icons.Default.LocationOn,
                                        contentDescription = null,
                                        Modifier.size(36.dp)
                                            .padding(5.dp)
                                    )
                                }
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    Icons.Default.StarRate,
                                    contentDescription = null
                                )
                                Text("4.5")
                            }

                        }
                    }
                }
                Spacer(
                    Modifier.height(17.dp)
                )
                Text(
                    stringResource(Res.string.statistics),
                    fontSize = 22.sp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Card(
                        elevation = CardDefaults.elevatedCardElevation(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier
                            .weight(1 / 3f)
                            .padding(3.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(3.dp)
                        ) {
                            Text(
                                "25", fontSize = 28.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                stringResource(Res.string.trips),
                                color = Color.LightGray,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Card(
                        elevation = CardDefaults.elevatedCardElevation(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier
                            .weight(1 / 3f)
                            .padding(3.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(3.dp)
                        ) {
                            Text(
                                "4.5", fontSize = 28.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                stringResource(Res.string.average),
                                color = Color.LightGray,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Card(
                        elevation = CardDefaults.elevatedCardElevation(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier
                            .weight(1 / 3f)
                            .padding(3.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(3.dp)
                        ) {
                            Text(
                                "120", fontSize = 28.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                stringResource(
                                    Res.string.reviews_driver
                                ),
                                color = Color.LightGray,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                Spacer(Modifier.height(27.dp))
                Text(
                    stringResource(
                        Res.string.reviews_list
                    ),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(6.dp)
                )
            }
            itemsIndexed(
                listOf(
                    ReviewData(
                        date = "19.05.2023",
                        rate = 5f,
                        name = "Bulka",
                        "Выехал на красный, так ещё и пьяный"
                    ),
                    ReviewData(
                        date = "16.08.2025",
                        rate = 4.3f,
                        name = "Виктория",
                        "Приятный человек"
                    ),
                    ReviewData(
                        date = "19.05.2023",
                        rate = 5f,
                        name = "Bulka",
                        "Выехал на красный, так ещё и пьяный"
                    ),
                    ReviewData(
                        date = "16.08.2025",
                        rate = 4.3f,
                        name = "Виктория",
                        "Приятный человек"
                    ),
                    ReviewData(
                        date = "19.05.2023",
                        rate = 5f,
                        name = "Bulka",
                        "Выехал на красный, так ещё и пьяный"
                    ),
                    ReviewData(
                        date = "16.08.2025",
                        rate = 4.3f,
                        name = "Виктория",
                        "Приятный человек"
                    ),
                    ReviewData(
                        date = "19.05.2023",
                        rate = 5f,
                        name = "Bulka",
                        "Выехал на красный, так ещё и пьяный"
                    ),
                    ReviewData(
                        date = "16.08.2025",
                        rate = 4.3f,
                        name = "Виктория",
                        "Приятный человек"
                    )
                )
            ) { _, item ->
                ReviewItem(item)
            }

        }


    }
    Box(modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter){
        var inputValue by remember { mutableStateOf("") }
        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = {
                Text(stringResource(Res.string.reviews_write))
            },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF3E92F4),
                unfocusedContainerColor = Color(0xFF3E92F4),
                disabledContainerColor = Color(0xFF3E92F4),
                focusedLabelColor = Color.Transparent,
                unfocusedLabelColor = Color.White,
                disabledLabelColor = Color.Black,
                disabledTextColor = Color.White,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.AutoMirrored.Filled.Send,
                        contentDescription = "send",
                        tint = Color.White
                    )
                }
            }
        )
    }

}
@Preview(showBackground = true)
@Composable
fun ReviewItem(reviewData: ReviewData = ReviewData(date = "19.05.2023",
    rate = 5f,
    name = "Bulka",
    "Выехал на красный, так ещё и пьяный"
)){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp),
        elevation = CardDefaults.elevatedCardElevation(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Default.DirectionsBus,
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
                    .clip(CircleShape)
                    .size(36.dp)
            )
            Column {
                Text(reviewData.name,
                    fontSize = 14.sp,
                    color = Color.DarkGray)
                Text(reviewData.review,
                    modifier = Modifier.widthIn(max = 200.dp))
                Text(reviewData.date,
                    fontSize = 14.sp,
                    color = Color.LightGray)
            }
            Box(modifier = Modifier
                .weight(1f)
                .padding(3.dp),
                contentAlignment = Alignment.CenterEnd
                ){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(reviewData.rate.toString(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold)
                    Icon(Icons.Default.StarRate,
                        contentDescription = null)
                }
            }

        }
    }
}