package org.city.drivesense

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.city.drivesense.navigation.RootComponent

fun MainViewController() = ComposeUIViewController {
    val root = remember { RootComponent(DefaultComponentContext(LifecycleRegistry())) }
//    IOSBackHandler(viewController = MainViewController()){
//        root.onBackPressed()
//    }
    App(root)
}