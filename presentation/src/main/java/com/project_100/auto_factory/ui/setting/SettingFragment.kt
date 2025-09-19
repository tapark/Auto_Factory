package com.project_100.auto_factory.ui.setting

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.project_100.auto_factory.R
import com.project_100.auto_factory.base.BaseFragment
import com.project_100.auto_factory.databinding.FragmentSettingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment: BaseFragment<FragmentSettingBinding, SettingFragmentViewModel>() {
    override val viewModel: SettingFragmentViewModel by viewModels()
    override val layout: Int = R.layout.fragment_setting

    override fun onBackPressed() {
        activity?.finish()
    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {

    }


    companion object {
        fun newInstance(): SettingFragment {
            return SettingFragment()
        }
    }
}