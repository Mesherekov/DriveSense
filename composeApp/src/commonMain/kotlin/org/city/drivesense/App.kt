package org.city.drivesense

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import drivesense.composeapp.generated.resources.Res
import drivesense.composeapp.generated.resources.home_bar
import drivesense.composeapp.generated.resources.person_bar
import org.city.drivesense.navigation.AccountScreen
import org.city.drivesense.navigation.BottomNavBar
import org.city.drivesense.navigation.BottomNavItem
import org.city.drivesense.navigation.HomeScreen
import org.city.drivesense.navigation.RootComponent
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        val childStack by rootComponent.childStack.subscribeAsState()
        Scaffold(
            bottomBar = {
                BottomNavBar(
                    listOf(
                        BottomNavItem(
                            stringResource(Res.string.home_bar),
                            Icons.Default.Home,
                            RootComponent.Config.HomeScreen
                        ),
                        BottomNavItem(
                            label = stringResource(Res.string.person_bar),
                            icon = Icons.Default.Person,
                            RootComponent.Config.AccountScreen,
                        )
                    ),
                    rootComponent = rootComponent
                )

            }
        ) { innerPadding ->
            Children(
                stack = childStack,
                animation = stackAnimation(slide())
            ) { child ->
                when (val instance = child.instance) {
                    is RootComponent.Child.AccountScreen -> AccountScreen(instance.component,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(innerPadding))
                    is RootComponent.Child.HomeScreen -> {
                        HomeScreen(
                            instance.component,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}