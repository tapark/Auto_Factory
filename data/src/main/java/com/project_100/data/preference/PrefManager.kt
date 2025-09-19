package com.teddy_park.data.preference

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.teddy_park.domain.model.fire_store.FortuneModel
import com.teddy_park.domain.model.fire_store.NumberModel

@SuppressLint("StaticFieldLeak")
object PrefManager {

    private lateinit var context: Context
    private lateinit var prefs: SharedPreferences

    private const val KEY_INIT_PREF_MANAGER = "KEY_INIT_PREF_MANAGER"

    fun init(mContext: Context) {
        context = mContext
        prefs = context.getSharedPreferences(KEY_INIT_PREF_MANAGER, Context.MODE_PRIVATE)
    }

    fun putString(key: String, value: String) = prefs.edit().putString(key, value).apply()
    fun getString(key: String, defaultValue: String) = prefs.getString(key, defaultValue) ?: ""

    fun putBoolean(key: String, value: Boolean) = prefs.edit().putBoolean(key, value).apply()
    fun getBoolean(key: String, defaultValue: Boolean) = prefs.getBoolean(key, defaultValue)

    fun putInt(key: String, value: Int) = prefs.edit().putInt(key, value).apply()
    fun getInt(key: String, defaultValue: Int) = prefs.getInt(key, defaultValue)

    fun putFloat(key: String, value: Float) = prefs.edit().putFloat(key, value).apply()
    fun getFloat(key: String, defaultValue: Float) = prefs.getFloat(key, defaultValue)

    fun putLong(key: String, value: Long) = prefs.edit().putLong(key, value).apply()
    fun getLong(key: String, defaultValue: Long) = prefs.getLong(key, defaultValue)

    fun remove(key: String) = prefs.edit().remove(key).apply()

//    fun putLoginUserInfo(value: SaveLoginInfo) {
//        val json = Gson().toJson(value)
//        prefs.edit().putString(KET_LOGIN_USER_INFO, json).apply()
//    }
//    fun getLoginUserInfo(): SaveLoginInfo? {
//        val json = prefs.getString(KET_LOGIN_USER_INFO, null)
//        return Gson().fromJson(json, object: TypeToken<SaveLoginInfo>() {}.type)
//    }
//    fun deleteLoginUserInfo() {
//        prefs.edit().remove(KET_LOGIN_USER_INFO).apply()
//    }
//
//    fun getCookieInfo(): String? {
//        return getLoginUserInfo()?.cookie
//    }

    var userCountry: String // KR US
        get() = prefs.getString("userCountry", "").toString()
        set(value) = prefs.edit().putString("userCountry", value).apply()

    var nameText: String
        get() = prefs.getString("nameText", "").toString()
        set(value) = prefs.edit().putString("nameText", value).apply()

    var genderType: Int
        get() = prefs.getInt("genderType", 0) // 0 남자 // 1 여자
        set(value) = prefs.edit().putInt("genderType", value).apply()

    var yearText: String
        get() = prefs.getString("yearText", "1984").toString()
        set(value) = prefs.edit().putString("yearText", value).apply()

    var monthText: String
        get() = prefs.getString("monthText", "12").toString()
        set(value) = prefs.edit().putString("monthText", value).apply()

    var dayText: String
        get() = prefs.getString("dayText", "24").toString()
        set(value) = prefs.edit().putString("dayText", value).apply()

    var birthType: Int
        get() = prefs.getInt("birthType", 0) // 0 양력 // 1 음력
        set(value) = prefs.edit().putInt("birthType", value).apply()

    var timeHourText: String
        get() = prefs.getString("timeHourText", "00").toString()
        set(value) = prefs.edit().putString("timeHourText", value).apply()

    var timeMinuteText: String
        get() = prefs.getString("timeMinuteText", "00").toString()
        set(value) = prefs.edit().putString("timeMinuteText", value).apply()

    var currentDate: Int
        get() = prefs.getInt("currentDate", 0)
        set(value) = prefs.edit().putInt("currentDate", value).apply()

    var targetSaturday: Long
        get() = prefs.getLong("targetSaturday", 0L)
        set(value) = prefs.edit().putLong("targetSaturday", value).apply()

    var todayLottoTryCount: Int
        get() = prefs.getInt("todayLottoRetryCount", 0)
        set(value) = prefs.edit().putInt("todayLottoRetryCount", value).apply()

    var allowFetchToday: Boolean
        get() = prefs.getBoolean("allowFetchToday", true)
        set(value) = prefs.edit().putBoolean("allowFetchToday", value).apply()

    var todayFortuneModel: FortuneModel?
        get() {
            val json = prefs.getString("todayFortuneModel", null)
            return Gson().fromJson(json, object: TypeToken<FortuneModel>() {}.type)
        }
        set(value) {
            val json = Gson().toJson(value)
            prefs.edit().putString("todayFortuneModel", json).apply()
        }
    var todayNumberModel: NumberModel?
        get() {
            val json = prefs.getString("todayNumberModel", null)
            return Gson().fromJson(json, object: TypeToken<NumberModel>() {}.type)
        }
        set(value) {
            val json = Gson().toJson(value)
            prefs.edit().putString("todayNumberModel", json).apply()
        }

    var lottoDataClickCount: Int
        get() = prefs.getInt("lottoDataClickCount", 0)
        set(value) = prefs.edit().putInt("lottoDataClickCount", value).apply()


    var appFirstOpen: Boolean
        get() = prefs.getBoolean("appFirstOpen", true)
        set(value) = prefs.edit().putBoolean("appFirstOpen", value).apply()

    var allowAlert: Boolean
        get() = prefs.getBoolean("allowAlert", false)
        set(value) = prefs.edit().putBoolean("allowAlert", value).apply()

    var stopShowingRound: String
        get() = prefs.getString("stopShowingRound", "").toString()
        set(value) = prefs.edit().putString("stopShowingRound", value).apply()
}
