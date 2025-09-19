package com.teddy_park.domain.model.sheet

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LottoData(
    val round: String = "",
    val date: String = "",
    val number1: String = "",
    val number2: String = "",
    val number3: String = "",
    val number4: String = "",
    val number5: String = "",
    val number6: String = "",
    val numberBonus: String = "",
    val win1Count: String = "",
    val win1Price: String = "",
    val win2Count: String = "",
    val win2Price: String = "",
    val win3Count: String = "",
    val win3Price: String = "",
    val win4Count: String = "",
    val win4Price: String = "",
    val win5Count: String = "",
    val win5Price: String = "",
    val totalCount: String = "",
    val totalPrice: String = ""
): Parcelable
