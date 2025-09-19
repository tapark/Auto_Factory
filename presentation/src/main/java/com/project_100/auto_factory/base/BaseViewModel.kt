package com.project_100.auto_factory.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project_100.auto_factory.util.SingleLiveEvent


abstract class BaseViewModel: ViewModel() {

    val isLoading = MutableLiveData<Boolean>(false)
    private val _backEvent = SingleLiveEvent<Unit>()
    val backEvent:LiveData<Unit> get() = _backEvent

    fun onClickBackEvent() {
        _backEvent.call()
    }
}