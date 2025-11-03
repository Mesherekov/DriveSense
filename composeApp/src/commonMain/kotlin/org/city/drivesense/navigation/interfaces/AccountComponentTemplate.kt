package org.city.drivesense.navigation.interfaces

interface AccountComponentTemplate {
    fun getPerson()
    fun changes(changes: Changes)
}
enum class Changes{
    NAME, AVATAR
}