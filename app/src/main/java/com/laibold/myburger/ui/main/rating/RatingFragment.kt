package com.laibold.myburger.ui.main.rating

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.laibold.myburger.R
import com.laibold.myburger.databinding.RatingFragmentBinding

class RatingFragment : Fragment() {

    private lateinit var binding: RatingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.rating_fragment,
            container,
            false
        )

        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        return binding.root
    }

}