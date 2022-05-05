package com.example.rickandmortynew.presentation.ui.extensions

import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

    fun Fragment.showToastShort(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    fun Fragment.showToastShort(@StringRes textFromRes: Int) {
        Toast.makeText(context, textFromRes, Toast.LENGTH_SHORT).show()
    }

    fun Fragment.showToastLong(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    fun Fragment.showToastLong(@StringRes textFromRes: Int) {
        Toast.makeText(context, textFromRes, Toast.LENGTH_LONG).show()
    }


    /**
     * View Extensions
     */

    fun View.visible() {
        visibility = View.VISIBLE
    }

    fun View.invisible() {
        visibility = View.INVISIBLE
    }

    fun View.gone() {
        visibility = View.GONE
    }

    fun View.enable() {
        isEnabled = true
    }

    fun View.disable() {
        isEnabled = false
    }
