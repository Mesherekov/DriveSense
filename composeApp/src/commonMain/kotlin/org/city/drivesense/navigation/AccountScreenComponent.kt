package org.city.drivesense.navigation

import com.arkivanov.decompose.ComponentContext
import org.city.drivesense.navigation.interfaces.AccountComponentTemplate
import org.city.drivesense.navigation.interfaces.Changes

class AccountScreenComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, AccountComponentTemplate  {
    override fun getPerson() {
        TODO("Not yet implemented")
    }

    override fun changes(changes: Changes) {
        when(changes){
            Changes.AVATAR -> {}
            Changes.NAME -> {}
        }
    }
}