package com.laibold.myburger.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.laibold.myburger.R
import com.laibold.myburger.databinding.MainFragmentBinding
import com.laibold.myburger.service.BurgerService

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var service: BurgerService

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

        service = BurgerService(context!!)
        service.importIngredients()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.setBurgers(service.getAll())
        viewModel.setRandomBurger(service.getRandomBurger())

        var s = "--- Burger of the Week ---\n"
        for (ingredient in viewModel.randomBurger.value?.ingredients!!) {
            s += ingredient.name + "\n"
        }

        binding.message.text = s

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
