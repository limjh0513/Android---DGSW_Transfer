package kr.hs.dgsw.sport_recruit.util

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

fun AppCompatActivity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.toast(message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(context: Context, message: String) {
    Toast.makeText(context.applicationContext, message, Toast.LENGTH_SHORT).show()
}


fun AppCompatActivity.startActivity(activity: Class<*>) {
    startActivity(Intent(this, activity))
}

fun Context.startActivity(activity: Class<*>) {
    startActivity(Intent(this, activity))
}

fun Context.startActivityIntent(intent: Intent) {
    startActivity(intent)
}

fun AppCompatActivity.startActivityAndFinish(activity: Class<*>) {
    startActivity(Intent(this, activity))
    finish()
}

fun AppCompatActivity.isNotNullOrEmpty(str: String?): Boolean {
    return !str.isNullOrEmpty()
}

fun String.lengthCheck(n: Int): Boolean {
    return !this.isNullOrEmpty() && this.length >= n
}

fun String.integerNotOver(n: Int): Boolean {
    val parseNum = Integer.parseInt(this)
    return this != null && 0 < parseNum && parseNum <= n
}

fun Fragment.isNotNullOrEmpty(str: String?): Boolean {
    return !str.isNullOrEmpty()
}

fun AppCompatActivity.testLog(message: String) {
    Log.e("TEST", message)
}

fun ViewModel.testLog(message: String) {
    Log.e("TEST", message)
}