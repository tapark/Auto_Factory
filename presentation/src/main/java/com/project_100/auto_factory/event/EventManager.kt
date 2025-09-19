package com.project_100.auto_factory.event

import android.os.Bundle
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

object EventManager {

    private var firebaseAnalytics = Firebase.analytics

    fun clickTaroButton(type: String) {
        firebaseAnalytics.logEvent("clickTaroButton", Bundle().apply {
            putString("type", type)
        })
    }

}