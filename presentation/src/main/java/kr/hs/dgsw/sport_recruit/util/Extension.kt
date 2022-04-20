package kr.hs.dgsw.sport_recruit.util

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.toast(message: Int){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.startActivity(activity: Class<*>){
    startActivity(Intent(this, activity::class.java))
}

fun AppCompatActivity.startActivityAndFinish(activity: Class<*>) {
    startActivity(Intent(this, activity::class.java))
    finish()
}

fun AppCompatActivity.testLog(message: String){
    Log.e("TEST", message)
}