package model.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Used to navigate between multiples elements
 */
class NavigationController<T>(
    initialRoute: T
) {
    private val stack: ArrayList<T> = arrayListOf(initialRoute)
    private var navigatorState by mutableStateOf(initialRoute)

    val currentRoute: T
        get() = navigatorState

    /**
     * Navigate to the previous screen.
     * Does nothing if no previous route existed.
     */
    fun navigateBack() {
        println("stack size : ${stack.size}")
        if (stack.size <= 1) return
        stack.removeLast()
        navigatorState = stack.last()
    }

    /**
     * Navigate to a given route.
     * Does nothing if the given route is not found.
     */
    fun navigateTo(route: T) {
        println("WIll navigate to :$route")
        stack.add(route)
        navigatorState = route
        println("stack size : ${stack.size}")
    }
}