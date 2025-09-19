package com.project_100.auto_factory.base

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.project_100.auto_factory.BR

abstract class BaseActivity<V: ViewDataBinding, VM: ViewModel>: AppCompatActivity() {

    lateinit var binding: V
    abstract val viewModel: VM
    abstract val layout: Int

    private var progressDialog: AppCompatDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layout)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { view, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(0, systemInsets.top, 0, systemInsets.bottom)
            insets
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // 뒤로가기 버튼이 눌렸을 때 실행할 코드
                activityBackPressed()
            }
        })

        initView(savedInstanceState)
        addObserver()
    }

    abstract fun activityBackPressed()

    abstract fun addObserver()

    abstract fun initView(savedInstanceState: Bundle?)


}