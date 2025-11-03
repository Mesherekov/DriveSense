package org.city.drivesense.navigation

import com.arkivanov.decompose.ComponentContext
import org.city.drivesense.navigation.interfaces.HomeComponentTemplate

class HomeScreenComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, HomeComponentTemplate  {
}