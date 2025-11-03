package org.city.drivesense
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
class AndroidBackHandler(
    private val activity: ComponentActivity,
    private val onBackPressed: () -> Boolean
) {

    fun enable() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (!onBackPressed()) {
                    isEnabled = false
                    activity.onBackPressed()
                    isEnabled = true
                }
            }
        }
        activity.onBackPressedDispatcher.addCallback(callback)
    }
}