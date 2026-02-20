package com.example.ozinsheexample.presentation.onbouading

import com.example.ozinsheexample.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ozinsheexample.data.OnbourdingModel
import com.example.ozinsheexample.databinding.ItemViewpagerOnboardingBinding

class OnbouardingAdapter(): RecyclerView.Adapter<OnbouardingAdapter.OnboardingViewHolder>() {

    private val onboardingModelList = mutableListOf<OnbourdingModel>()
    fun submitList(list: List<OnbourdingModel>){
        onboardingModelList.clear()
        onboardingModelList.addAll(list)
        notifyDataSetChanged()
    }

    inner class OnboardingViewHolder(private val binding: ItemViewpagerOnboardingBinding): RecyclerView.ViewHolder(binding.root){

        fun bindItem(model: OnbourdingModel) {
            binding.tvTitleOnbourding.text = model.title
            binding.tvDiscriptionOnbourding.text = model.description
            binding.imgTvOnboarding.setImageResource(model.imageId)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val binding = ItemViewpagerOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnboardingViewHolder(binding)
    }


    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bindItem(onboardingModelList[position])

    }

    override fun getItemCount(): Int {
        return onboardingModelList.size
    }
}