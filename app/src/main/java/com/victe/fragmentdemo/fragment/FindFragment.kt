package com.victe.fragmentdemo.fragment

import android.os.Bundle
import android.widget.Button
import com.victe.fragmentdemo.R
import com.victe.victefragment.LazyFragment

/**
 * Created by 13526 on 2018/1/30.
 */
class FindFragment : LazyFragment() {
    companion object {
        fun newInstance(isLazyLoad: Boolean): FindFragment {
            val args = Bundle()
            args.putBoolean(LazyFragment.INTENT_BOOLEAN_LAZYLOAD, isLazyLoad)
            val fragment = FindFragment()
            fragment.setArguments(args)

            return fragment
        }
    }

    override fun onFragmentStartLazy() {

    }

    override fun onFragmentStopLazy() {

    }

    override fun onCreateViewLazy(savedInstanceState: Bundle?) {
        setContentView(R.layout.frag4)
    }

    override fun onResumeLazy() {

    }

    override fun onDestroyViewLazy() {

    }

}