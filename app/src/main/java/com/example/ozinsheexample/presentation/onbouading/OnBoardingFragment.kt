package com.example.ozinsheexample.presentation.onbouading

import OnbourdingInfoList
import com.example.ozinsheexample.R

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.ozinsheexample.presentation.onbouading.OnbouardingAdapter

import com.example.ozinsheexample.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentOnBoardingBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnbouardingAdapter()
        adapter.submitList(OnbourdingInfoList.onbourdingModelist)
        binding.viewPager2OnboardingFragment.adapter = adapter

        val viewPagerCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == OnbourdingInfoList.onbourdingModelist.size - 1) {
                    binding.btnNextOnboardingFragment.visibility = View.VISIBLE
                    binding.btnSkipOnboardingFragment.visibility = View.VISIBLE
                } else {
                    binding.btnNextOnboardingFragment.visibility = View.INVISIBLE
                    binding.btnSkipOnboardingFragment.visibility = View.VISIBLE
                }
            }
        }


        binding.dotsIndicator.setViewPager2(binding.viewPager2OnboardingFragment)

        binding.viewPager2OnboardingFragment.registerOnPageChangeCallback(viewPagerCallback)

        binding.btnSkipOnboardingFragment.setOnClickListener() {
            findNavController().navigate(R.id.loginFragment)
         }


    }


}