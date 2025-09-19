package com.project_100.auto_factory.ui.home

import android.Manifest
import android.annotation.SuppressLint
import android.app.AppOpsManager
import android.app.usage.NetworkStats
import android.app.usage.NetworkStatsManager
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.telephony.TelephonyManager
import android.util.Log
import androidx.annotation.RequiresPermission
import androidx.fragment.app.viewModels
import com.project_100.auto_factory.R
import com.project_100.auto_factory.base.BaseFragment
import com.project_100.auto_factory.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>() {
    override val viewModel: HomeFragmentViewModel by viewModels()
    override val layout: Int = R.layout.fragment_home

    override fun onResume() {
        super.onResume()
        trackData()
    }

    override fun onBackPressed() {
        activity?.finish()
    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {
        if (!hasUsageAccessPermission()) { // 권한 없으면 설정화면으로 이동
            requestUsageAccessPermission()
        } else { // 권한 있음 → 데이터 추적 시작
            trackData()
        }
    }



    private fun trackData() {
        val startTime = 0L // 📌 기기 기록 시작 시점부터
        val endTime = System.currentTimeMillis()
        val (mobileBytes, wifiBytes) = getTotalDataUsage(requireContext(), startTime, endTime)

        binding.dataTextView.text = "모바일 데이터: ${mobileBytes / (1024*1024)} MB"
        binding.wifiTextView.text = "와이파이 데이터: ${wifiBytes / (1024*1024)} MB"
    }


    fun hasUsageAccessPermission(): Boolean {
        val appOps = requireContext().getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
        val mode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            appOps.unsafeCheckOpNoThrow(
                AppOpsManager.OPSTR_GET_USAGE_STATS,
                android.os.Process.myUid(),
                requireContext().packageName
            )
        } else {
            appOps.checkOpNoThrow(
                AppOpsManager.OPSTR_GET_USAGE_STATS,
                android.os.Process.myUid(),
                requireContext().packageName
            )
        }
        return mode == AppOpsManager.MODE_ALLOWED
    }

    fun requestUsageAccessPermission() {
        try {
            val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS).apply {
                data = Uri.parse("package:${requireContext().packageName}")
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            requireContext().startActivity(intent)
        } catch (e: Exception) {
            Log.e("Permission", "사용기록 액세스 권한 요청 실패", e)
        }
    }

    @SuppressLint("MissingPermission")
    fun getTotalDataUsage(context: Context, start: Long, end: Long): Pair<Long, Long> {
        val networkStatsManager =
            context.getSystemService(Context.NETWORK_STATS_SERVICE) as NetworkStatsManager

        var mobileTotal = 0L
        var wifiTotal = 0L

        try {
            // 📶 모바일 데이터 합계
            val mobileStats = networkStatsManager.querySummary(
                ConnectivityManager.TYPE_MOBILE, null, start, end
            )
            val mobileBucket = NetworkStats.Bucket()
            while (mobileStats.hasNextBucket()) {
                mobileStats.getNextBucket(mobileBucket)
                mobileTotal += mobileBucket.rxBytes + mobileBucket.txBytes
            }
            mobileStats.close()

            // 📡 Wi-Fi 데이터 합계
            val wifiStats = networkStatsManager.querySummary(
                ConnectivityManager.TYPE_WIFI, "", start, end
            )
            val wifiBucket = NetworkStats.Bucket()
            while (wifiStats.hasNextBucket()) {
                wifiStats.getNextBucket(wifiBucket)
                wifiTotal += wifiBucket.rxBytes + wifiBucket.txBytes
            }
            wifiStats.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return Pair(mobileTotal, wifiTotal)
    }






    companion object {

        var PERMISSIONS = arrayOf(
            Manifest.permission.POST_NOTIFICATIONS,
        )

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}