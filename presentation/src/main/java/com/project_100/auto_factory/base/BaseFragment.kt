package com.project_100.auto_factory.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.project_100.auto_factory.BR

abstract class BaseFragment<V: ViewDataBinding, VM: ViewModel>: Fragment() {

    lateinit var binding: V
    abstract val viewModel: VM
    abstract val layout: Int

    private lateinit var backPressedCallback: OnBackPressedCallback

    private var progressDialog: AppCompatDialog? = null

    override fun onStart() {
        super.onStart()
        backPressedCallback = object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backPressedCallback)
    }

    override fun onStop() {
        super.onStop()
        backPressedCallback.remove()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addObserver()
        initView(savedInstanceState)

    }

    protected fun showToastMessage(msg:String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    abstract fun onBackPressed()

    abstract fun addObserver()

    abstract fun initView(savedInstanceState: Bundle?)


//    fun showProgress() {
//        progressDialog = AppCompatDialog(requireContext())
//        progressDialog?.apply {
//            setCancelable(false)
//            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            setContentView(R.layout.dialog_loading)
//            show()
//        }
//
//        val size = dpToPx(100, requireContext()).toInt()
//
//        Glide.with(this)
//            .load(R.raw.gif_loading)
//            .apply(RequestOptions().override(size, size))
//            .into(progressDialog?.findViewById<ImageView>(R.id.loadingImageView) as ImageView)
//    }
//
//    fun hideProgress() {
//        progressDialog?.dismiss()
//    }

}