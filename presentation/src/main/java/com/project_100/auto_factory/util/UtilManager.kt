package com.project_100.auto_factory.util

import android.content.Context
import android.graphics.Color
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.project_100.auto_factory.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object UtilManager {

    fun dpToPx(context: Context, dp: Int): Int {
        val density = context.resources.displayMetrics.density
        return (dp * density).toInt()
    }

    fun pxToDp(context: Context, px: Int): Int {
        val density = context.resources.displayMetrics.density
        return (px / density).toInt()
    }

    fun getCurrentDateAsInt(): Int {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.ENGLISH)
        val formattedDate = dateFormat.format(calendar.time)
        return formattedDate.toInt()
    }

    fun getCurrentDate(format: String = "yyyyMMdd"): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat(format, Locale.ENGLISH)
        val formattedDate = dateFormat.format(calendar.time)
        return formattedDate
    }

}

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")