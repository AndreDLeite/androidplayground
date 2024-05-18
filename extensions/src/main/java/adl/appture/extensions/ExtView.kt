package adl.appture.extensions

import android.os.SystemClock
import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

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

fun View.useSingleClickAction(
    delayTime: Long = 2000L,
    handler: suspend CoroutineScope.(v: View?) -> Unit
) {
    var lastTimeClicked = 0L

    setOnClickListener { v ->
        if(SystemClock.elapsedRealtime() - lastTimeClicked >= delayTime) {
            lastTimeClicked = SystemClock.elapsedRealtime()
            runBlocking {
                handler(v)
            }
        }
    }
}