package io.kiwik.reign.utilities

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

/**
 * Verifica si tienes permisos
 */
fun Context.hasPermission(vararg permissions: String): Boolean {
    return permissions.all { ActivityCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED }
}


fun AppCompatActivity.checkAndRequestPermission(permission: String, code: Int): Boolean { // todo: mejorar esta funcion
    if (hasPermission(permission)) return true
    ActivityCompat.requestPermissions(this, arrayOf(permission), code)
    return false
}


fun AppCompatActivity.checkAndRequestPermission(code: Int, vararg permissions: String): Boolean {
    val notPermitted = permissions.filter { !hasPermission(it) }
    if (notPermitted.isEmpty()) return true
    ActivityCompat.requestPermissions(this, notPermitted.toTypedArray(), code)
    return false
}
