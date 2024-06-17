package adl.shared.extensions

import android.app.Activity
import android.view.View

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}
