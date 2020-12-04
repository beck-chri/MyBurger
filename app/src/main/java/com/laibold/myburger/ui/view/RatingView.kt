package com.laibold.myburger.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.annotation.AttrRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.laibold.myburger.R
import com.laibold.myburger.databinding.RatingViewBinding

class RatingView : ConstraintLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(
        context: Context, attrs: AttributeSet?,
        @AttrRes defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr)

    private var binding: RatingViewBinding

    init {
        val inflater = LayoutInflater.from(context)
        DataBindingUtil.inflate<RatingViewBinding>(inflater, R.layout.rating_view, this, true);
        binding = RatingViewBinding.inflate(inflater)
        binding.button1.setOnClickListener {
            Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show()
        }
        binding.button1.setOnClickListener { toast(1) }
        binding.button2.setOnClickListener { toast(2) }
        binding.button3.setOnClickListener { toast(3) }
        binding.button5.setOnClickListener { toast(4) }
        binding.button4.setOnClickListener { toast(5) }

        //Toast.makeText(context, this.isFocusable.toString(), LENGTH_SHORT).show()
    }

    private fun toast(i: Int) {
        Toast.makeText(context, "Button$i", LENGTH_SHORT).show()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener {
            Toast.makeText(context, "Button", LENGTH_SHORT).show()
        }
    }

}
