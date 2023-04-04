package adl.appture.extensions

import android.view.View

val View.visible: View
    get() {
        visibility = View.VISIBLE
        return this
    }

val View.invisible: View
    get() {
        visibility = View.INVISIBLE
        return this
    }

val View.gone: View
    get() {
        visibility = View.GONE
        return this
    }

fun hideViewsWithGone(views: List<View>) {
    views.forEach {
        it.visibility = View.VISIBLE
    }
}