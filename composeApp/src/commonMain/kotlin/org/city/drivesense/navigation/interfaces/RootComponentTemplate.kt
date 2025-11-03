package org.city.drivesense.navigation.interfaces

import org.city.drivesense.navigation.RootComponent

interface RootComponentTemplate {
    fun navigateTo(route: RootComponent.Config)
    fun navigateToCanBack(route: RootComponent.Config)

    fun getRoute(): String
    var currentRoute: String
}