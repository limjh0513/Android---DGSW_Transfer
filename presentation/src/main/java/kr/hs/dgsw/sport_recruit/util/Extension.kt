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
    startActivity(Intent(this, activity::class.java))
}

fun AppCompatActivity.startActivityAndFinish(activity: Class<*>) {
    startActivity(Intent(this, activity::class.java))
    finish()
}

fun AppCompatActivity.isNotNullOrEmpty(str: String?): Boolean {
    return !str.isNullOrEmpty()
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