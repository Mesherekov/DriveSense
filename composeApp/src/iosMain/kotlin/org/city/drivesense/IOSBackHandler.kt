package org.city.drivesense
import platform.UIKit.UIGestureRecognizer
import platform.UIKit.UIGestureRecognizerDelegateProtocol
import platform.UIKit.UIViewController
import platform.UIKit.navigationController
import platform.darwin.NSObject

class IOSBackHandler(
    private val viewController: UIViewController,
    private val onBackPressed: () -> Boolean
) {
    fun setupBackButton() {
        viewController.navigationController?.interactivePopGestureRecognizer?.delegate =
            object : NSObject(), UIGestureRecognizerDelegateProtocol {
                override fun gestureRecognizerShouldBegin(gestureRecognizer: UIGestureRecognizer): Boolean {
                    return onBackPressed().also { handled ->
                        if (!handled) {
                            viewController.navigationController?.popViewControllerAnimated(true)
                        }
                    }
                }
            }
    }
}