package com.apptikar.yaskon.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.apptikar.yaskon.R
import com.apptikar.yaskon.databinding.ActivityOnBoardingBinding

class OnBoarding : AppCompatActivity() {
    private val viewModel: OnBoardingViewModel by viewModels()
    lateinit var binding: ActivityOnBoardingBinding
    lateinit var nav: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_on_boarding)
        setContentView(binding.root)

        binding.viewModel = viewModel
        nav = Navigation.findNavController(this, R.id.onBoardingNavLayout)
        binding.skipText.setOnClickListener {
            navigateToBudgetRange()
        }






    }

    fun navigateToBudgetRange()
    {
         if (binding.pageNumber.text == "1/2" )
         {
             nav.navigate(R.id.action_global_to_budget_range)
         }


    }







}