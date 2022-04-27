package kr.hs.dgsw.data.util

import android.content.Context
import android.content.SharedPreferences

object PreferenceManager {
    private const val PREF_USER = "user"

    fun setUser(context: Context, userIdx: Int) {
        getDefaultSharedPreferences(context).edit().putInt(PREF_USER, userIdx).apply()
    }

    fun getUser(context: Context): Int {
        return getDefaultSharedPreferences(context).getInt(PREF_USER, -1)
    }

    private fun getDefaultSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context),
            getDefaultSharedPreferencesMode())
    }

    private fun getDefaultSharedPreferencesName(context: Context): String {
        return context.packageName.toString() + "_preferences"
    }

    private fun getDefaultSharedPreferencesMode(): Int {
        return Context.MODE_PRIVATE
    }
}