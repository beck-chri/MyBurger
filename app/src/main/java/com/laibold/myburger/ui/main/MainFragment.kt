package com.laibold.myburger.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.laibold.myburger.R
import com.laibold.myburger.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.randomBurger.observe(viewLifecycleOwner, {
            binding.burgerOtdNameTv.text = viewModel.getRandomBurgerName()

            val ingredientsString = resources.getString(R.string.ingredients)
                .format(viewModel.getRandomBurgerIngredientCount())
            binding.numberOfIngredientsTv.text = ingredientsString

            binding.burgerOtdPriceTv.text = viewModel.getRandomBurgerPrice()
            binding.ingredientsListTv.text = viewModel.getRandomBurgerIngredients()
        })

        binding.shuffleIngredientsBtn.setOnClickListener { onClickRandomBurger() }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun onClickRandomBurger() {
        viewModel.createRandomBurger()
    }

}
