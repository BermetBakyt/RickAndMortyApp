package com.example.rickandmortynew.presentation.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatTextView

class ClickableTextView : AppCompatTextView, View.OnTouchListener {

    constructor(context: Context) : super(context) {
        setup()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setup()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        setup()
    }

    private fun setup() {
        setOnTouchListener(this)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if (hasOnClickListeners()) {
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    isSelected = true
                }
                MotionEvent.ACTION_UP,
                MotionEvent.ACTION_CANCEL
                -> {
                    isSelected = false
                }
            }
        }
        return false
    }
}