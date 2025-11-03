package org.city.drivesense

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.retainedComponent
import org.city.drivesense.navigation.RootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val root = RootComponent(retainedComponent {
            it
        })
        AndroidBackHandler(this) {
            root.onBackPressed()
        }.enable()
        setContent {
            App(root)
        }
    }
}

