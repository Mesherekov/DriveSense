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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import drivesense.composeapp.generated.resources.Res
import drivesense.composeapp.generated.resources.ava
import drivesense.composeapp.generated.resources.reviews
import org.city.drivesense.db.ReviewData
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun AccountScreen(
    component: AccountScreenComponent,
    modifier: Modifier = Modifier.fillMaxWidth(),
    rootComponent: RootComponent
){
    Column(modifier) {
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd) {
            Row(Modifier.padding(2.dp)) {
                IconButton(onClick = {}){
                    Icon(Icons.Default.Edit,
                        contentDescription = "edit")
                }
                IconButton(onClick = {}){
                    Icon(Icons.Default.Settings,
                        contentDescription = "settings")
                }
            }
        }
        Row(Modifier.padding(4.dp)) {
            Image(
                painterResource(Res.drawable.ava),
                contentDescription = "avatar",
                Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Text("Иван Иванов",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(12.dp))
        Card(modifier = Modifier.weight(1f)) {
            LazyColumn(Modifier
                .fillMaxWidth()
                .padding(5.dp)) {
                item {
                    Text(stringResource(Res.string.reviews),
                        fontSize = 26.sp)
                    Spacer(Modifier.height(8.dp))
                }
                itemsIndexed(listOf(
                    ReviewData(
                        date = "01.02.2025",
                        rate = 2.4f,
                        name = "Иван Иванов",
                        "Автобус опоздал на 30 минут."
                    ),
                    ReviewData(
                        date = "05.02.2025",
                        rate = 3.0f,
                        name = "Иван Иванов",
                        "Резко трогаются и тормозят."
                    )
                )){_, item ->
                    MyReviewItem(
                        item,
                        rootComponent = rootComponent)

                }
            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun MyReviewItem(
    reviewData: ReviewData = ReviewData(date = "19.05.2023",
    rate = 5f,
    name = "Bulka",
    "Выехал на красный, так ещё и пьяный"
),
    rootComponent: RootComponent){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .clickable{
            rootComponent.navigateToCanBack(RootComponent.Config.DriverScreen)
        },
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
                Text("Маршрут 22",
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