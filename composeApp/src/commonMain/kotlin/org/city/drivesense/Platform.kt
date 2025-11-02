package org.city.drivesense

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform