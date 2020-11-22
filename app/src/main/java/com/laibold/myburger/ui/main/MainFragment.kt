package com.laibold.myburger.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.laibold.myburger.R
import com.laibold.myburger.databinding.MainFragmentBinding
import com.laibold.myburger.service.CurrencyFormatter

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

        viewModel.randomBurger.observe(viewLifecycleOwner, Observer { showRandomBurger() })
        binding.shuffleIngredientsBtn.setOnClickListener { onClickRandomBurger() }

        binding.scrollView.setOnScrollChangeListener { _, _, scrollY, _, _ ->
            val scaleVal = (1 + (scrollY.toFloat() / 9000))
            binding.imageView.scaleX = scaleVal
            binding.imageView.scaleY = scaleVal
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun onClickRandomBurger() {
        viewModel.createRandomBurger()
    }

    private fun showRandomBurger() {
        val burger = viewModel.randomBurger.value
        if (burger != null) {
            if (burger.name == "") {
                burger.name = resources.getString(R.string.burger_of_the_day)
            }
            binding.burgerInfo.burgerOtdNameTv.text = burger.name
            binding.burgerInfo.numberOfIngredientsTv.text = viewModel.getIngredientsHeadline(
                resources.getString(R.string.ingredients),
                resources.getString(burger.getDietType().stringId)
            )
            binding.burgerInfo.burgerOtdPriceTv.text = CurrencyFormatter.format(burger.getPrice())
            binding.burgerInfo.ingredientsListTv.text = burger.getIngredientString()

            binding.burgerInfo.energy.myValue = burger.energy.toString() + " kJ"
            binding.burgerInfo.fat.myValue = burger.fat.toString() + " g"
            binding.burgerInfo.carbs.myValue = burger.carbs.toString() + " g"
            binding.burgerInfo.protein.myValue = burger.protein.toString() + " g"
        }
    }

}
