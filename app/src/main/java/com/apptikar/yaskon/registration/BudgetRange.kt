package com.apptikar.yaskon.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apptikar.yaskon.databinding.FragmentBudgetRangeBinding


class BudgetRange : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    lateinit var binding: FragmentBudgetRangeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
  binding = FragmentBudgetRangeBinding.inflate(layoutInflater)
        binding.priceRangeSlider.setPadding(0, 0, 0, 0)
        binding.priceRangeSlider.addOnChangeListener{ slider, _, _ ->
            val values =  slider.values
            binding.minPriceTextBudget.text = values[0].toInt().toString()+" EGP"
            binding.maxPriceTextBudget.text = values[1].toInt().toString()+" EGP"
        }
    binding.backButtonBudget.setOnClickListener {
        (activity as OnBoarding).nav.popBackStack()
    }
        return binding.root

    }

    override fun onResume() {
        super.onResume()
        (activity as OnBoarding).binding.pageNumber.text = "2/2"
    }



}