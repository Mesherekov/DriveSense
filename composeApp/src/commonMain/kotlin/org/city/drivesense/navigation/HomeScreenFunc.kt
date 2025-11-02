package org.city.drivesense.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.ListAlt
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.QrCode2
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import drivesense.composeapp.generated.resources.Res
import drivesense.composeapp.generated.resources.help
import drivesense.composeapp.generated.resources.recent_routes
import drivesense.composeapp.generated.resources.reviews
import drivesense.composeapp.generated.resources.routes_res
import drivesense.composeapp.generated.resources.scan_qr
import drivesense.composeapp.generated.resources.search_bar
import drivesense.composeapp.generated.resources.share_trip
import drivesense.composeapp.generated.resources.train
import org.city.drivesense.db.TransportRoute
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreen(
    component: HomeScreenComponent,
    modifier: Modifier = Modifier.fillMaxWidth()
){
    var searchText by remember { mutableStateOf("") }
    var isSearchActive by remember { mutableStateOf(false) }
    Column(modifier = modifier
        .padding(4.dp)) {
        SearchBar(
            query = searchText,
            onQueryChange = { searchText = it },
            onSearch = { /* Выполнить поиск */ },
            active = isSearchActive,
            onActiveChange = { isSearchActive = it },
            placeholder = { Text(stringResource(Res.string.search_bar)+"...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            trailingIcon = {
                if (searchText.isNotEmpty()) {
                    IconButton(onClick = { searchText = "" }) {
                        Icon(Icons.Default.Close, contentDescription = "Очистить")
                    }
                }
            }){}
        Spacer(Modifier.height(12.dp))
        LazyColumn {
            item {
                Row(modifier = modifier) {
                    Image(
                        painter = painterResource(Res.drawable.train),
                        contentDescription = "train",
                        modifier = Modifier.weight(1 / 2f)
                    )
                    Text(
                        stringResource(Res.string.share_trip),
                        modifier = Modifier.weight(1 / 2f),
                        fontWeight = FontWeight.Bold,
                        fontSize = 23.sp
                    )
                }


                Row {
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .weight(1 / 2f)
                            .padding(5.dp)
                            .clickable{

                            },
                        elevation = CardDefaults.elevatedCardElevation(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Default.QrCode2,
                                tint = Color(0xFF2391F4),
                                contentDescription = "qr_code",
                                modifier = Modifier.size(48.dp)
                            )
                            Text(
                                stringResource(
                                    Res.string.scan_qr
                                ),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .weight(1 / 2f)
                            .padding(5.dp)
                            .clickable{

                            },
                        elevation = CardDefaults.elevatedCardElevation(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Default.Schedule,
                                tint = Color(0xFF2391F4),
                                contentDescription = "last_trips",
                                modifier = Modifier.size(48.dp)
                            )
                            Text(
                                stringResource(Res.string.routes_res),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row {
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .weight(1 / 2f)
                            .padding(5.dp)
                            .clickable{

                            },
                        elevation = CardDefaults.elevatedCardElevation(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ListAlt,
                                tint = Color(0xFF2391F4),
                                contentDescription = "reviews",
                                modifier = Modifier.size(48.dp)
                            )
                            Text(
                                stringResource(
                                    Res.string.reviews
                                ),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .weight(1 / 2f)
                            .padding(5.dp)
                            .clickable{

                            },
                        elevation = CardDefaults.elevatedCardElevation(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Default.QuestionMark,
                                tint = Color(0xFF2391F4),
                                contentDescription = "question",
                                modifier = Modifier.size(48.dp)
                            )
                            Text(
                                stringResource(Res.string.help),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Spacer(Modifier.height(12.dp))
                Text(
                    stringResource(Res.string.recent_routes),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }

            itemsIndexed(listOf(TransportRoute(
                "Маршрут 22",
                "12:30"
            ),
                TransportRoute(
                    "Маршрут 110",
                    "16:20"
                ),
                TransportRoute(
                    "Маршрут 45",
                    "19:00"
                ),
                TransportRoute(
                    "Маршрут 4",
                    "09:53"
                )
                )){_, item ->
                TripItem(item)
            }


    }
        }

}



@Composable
fun TripItem(
    transportRoute: TransportRoute
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable{

            },
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Default.DirectionsBus,
                contentDescription = "bus",
                modifier = Modifier
                    .size(36.dp)
                    .padding(4.dp),
                tint = Color(0xFF208DF3)
            )
            Column {
                Text(transportRoute.trip)
                Text(transportRoute.time,
                    color = Color.LightGray,
                    fontSize = 14.sp)
            }
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "arrow",
                    tint = Color.LightGray)
            }
        }
    }
}