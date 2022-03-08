package io.kiwik.reign.utilities

import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.content.res.Resources
import android.util.TypedValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

inline fun <T, reified S> Iterable<T>.reduce(first: S, operation: (acc: S, T) -> S): S {
    val iterator = this.iterator()
    if (!iterator.hasNext()) throw UnsupportedOperationException("Empty collection can't be reduced.")
    var accumulator: S = first
    while (iterator.hasNext()) {
        accumulator = operation(accumulator, iterator.next())
    }
    return accumulator
}

fun Int.percentOf(total: Number) = if (total == 0) 0f else (this.toFloat() / total.toFloat()) * 100f


inline fun <T, S> List<T>.filterMap(filterBy: (T) -> Boolean, mapBy: (T) -> S): List<S> {
    return filter(filterBy).map(mapBy)
}


inline fun getValueAnimator(
    forward: Boolean = true, duration: Long, interpolator: TimeInterpolator,
    crossinline updateListener: (progress: Float) -> Unit
): ValueAnimator {
    val a =
        if (forward) ValueAnimator.ofFloat(0f, 1f)
        else ValueAnimator.ofFloat(1f, 0f)
    a.addUpdateListener { updateListener(it.animatedValue as Float) }
    a.duration = duration
    a.interpolator = interpolator
    return a
}

inline val Int.dp: Int
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics
    ).toInt()

inline val Float.dp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics
    )


/**
 * Tener en cuenta que los valores de cada live data pueden ser nulos porque pueden obtenerse en tiempos distintos
 *  livedata + livedata
 */
operator fun <T, K> LiveData<T>.plus(liveData: LiveData<K>): LiveData<Pair<T?, K?>> {
    val result = MediatorLiveData<Pair<T?, K?>>()
    val block: (T?, K?) -> Pair<T?, K?> = { a, b ->
        a to b
    }
    result.addSource(this) {
        result.value = block.invoke(this.value, liveData.value)
    }
    result.addSource(liveData) {
        result.value = block.invoke(this.value, liveData.value)
    }
    return result
}

fun Any?.isNull() = this == null
fun Any?.isNotNull() = !isNull()

fun <T> MutableList<T>.addOrRemove(element: T) {
    if (contains(element)) {
        remove(element)
    } else {
        add(element)
    }
}

fun Int.toBoolean(): Boolean {
    return when (this) {
        0 -> false
        1 -> true
        else -> false
    }
}

fun String.capitalizeWords(): String = split(" ").joinToString(" ") { it.capitalize() }