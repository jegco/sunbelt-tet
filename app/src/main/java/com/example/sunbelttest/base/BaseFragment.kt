package com.example.sunbelttest.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.sunbelttest.conf.App

abstract class BaseFragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.applicationContext as App).component.inject(this)
    }
}