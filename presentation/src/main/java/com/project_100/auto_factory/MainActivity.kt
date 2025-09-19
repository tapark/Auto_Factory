package com.project_100.auto_factory

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import com.project_100.auto_factory.base.BaseActivity
import com.project_100.auto_factory.databinding.ActivityMainBinding
import com.project_100.auto_factory.ui.home.HomeFragment
import com.project_100.auto_factory.ui.setting.SettingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {
    override val viewModel: MainActivityViewModel by viewModels()
    override val layout: Int = R.layout.activity_main

    var homeFragment: HomeFragment? = null
    var settingFragment: SettingFragment? = null

    override fun activityBackPressed() {
        finish()
    }

    override fun addObserver() {
    }

    override fun initView(savedInstanceState: Bundle?) {
        initNavigation()
        showHomeFragment()
    }

    private fun initNavigation() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.bottomNavigationView) { _, _ ->
            WindowInsetsCompat.CONSUMED
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> { showHomeFragment() }
                R.id.nav_setting -> { showSettingFragment() }
            }
            true
        }
    }

    private fun showHomeFragment() {
        hideAllFragment()
        homeFragment = supportFragmentManager.findFragmentByTag("homeFragment") as? HomeFragment ?: HomeFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        if (homeFragment!!.isAdded) {
            transaction.show(homeFragment!!)
        } else {
            transaction.add(R.id.fragmentContainerView, homeFragment!!, "homeFragment")
        }
        try {
            transaction.commit()
        } catch (e: IllegalStateException) {
            transaction.commitAllowingStateLoss()
        }
    }

    private fun showSettingFragment() {
        hideAllFragment()
        settingFragment = supportFragmentManager.findFragmentByTag("settingFragment") as? SettingFragment ?: SettingFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        if (settingFragment!!.isAdded) {
            transaction.show(settingFragment!!)
        } else {
            transaction.add(R.id.fragmentContainerView, settingFragment!!, "settingFragment")
        }
        try {
            transaction.commit()
        } catch (e: IllegalStateException) {
            transaction.commitAllowingStateLoss()
        }
    }

    private fun hideAllFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        if (homeFragment != null) {
            transaction.hide(homeFragment!!)
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment!!)

            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commitAllowingStateLoss()
        }
    }
}