package com.project_100.auto_factory.manager

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.gson.Gson
import com.teddy_park.domain.model.sheet.LottoData
import kotlinx.coroutines.flow.Flow
import com.google.gson.reflect.TypeToken
import com.project_100.auto_factory.util.dataStore
import kotlinx.coroutines.flow.map

object DataManager {

    private val LOTTO_DATA_KEY = stringPreferencesKey("LottoData")

    suspend fun putLottoData(context: Context, lottoData: MutableList<LottoData>) {
        val jsonString = Gson().toJson(lottoData) // 리스트를 JSON으로 변환
        context.dataStore.edit { preferences ->
            preferences[LOTTO_DATA_KEY] = jsonString
        }
    }

    /** 🚀 2. 사용자 리스트 불러오기 (Flow 사용) */
    fun getLottoData(context: Context): Flow<MutableList<LottoData>> {
        return context.dataStore.data.map { preferences ->
            val jsonString = preferences[LOTTO_DATA_KEY] ?: "[]" // 기본값 빈 리스트
            val type = object : TypeToken<MutableList<LottoData>>() {}.type
            Gson().fromJson(jsonString, type) ?: mutableListOf()
        }
    }


}